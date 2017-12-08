package com.scavi.brainsqueeze.codefight.bot;

import java.util.HashMap;
import java.util.Map;

public class Dropbot {
    public boolean incorrectPasscodeAttempts(String passcode, String[] attempts) {
        int incorrect = 0;
        for (int i = 0; i < attempts.length && incorrect < 10; ++i) {
            if (attempts[i].equals(passcode)) {
                incorrect = 0;
            } else {
                incorrect++;
            }
        }
        return incorrect >= 10;
    }


    public String losslessDataCompression(String inputString, int width) {
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < inputString.length(); ++i) {
            int range = i < width ? 0 : i - width;

            String cacheWindow = inputString.substring(range, i);

            int j = i + 1;
            while (j <= inputString.length() && cacheWindow.contains(inputString.substring(i, j))) {
                j++;
            }

            // not in cache
            if (i == j - 1) {
                compressed.append(inputString.charAt(i));
            } else {
                int offset = Math.max(0, i - width);
                String cacheLookup = inputString.substring(i, j - 1);
                int start = offset + cacheWindow.indexOf(cacheLookup);
                int end = cacheLookup.length();
                compressed.append(String.format("(%d,%d)", start, end));
                i = j - 2;
            }
        }
        return compressed.toString();
    }

    public String displayDiff(String oldVersion, String newVersion) {
        Map<Cache, String> dpCache = new HashMap<>();
        return diff(oldVersion, newVersion, dpCache).replace("][", "").replace(")(", "");
    }

    private String diff(String oldVersion, String newVersion, Map<Cache, String> dpCache) {
        if (oldVersion.isEmpty()) {
            return String.format("(%s)", newVersion);
        } else if (newVersion.isEmpty()) {
            return String.format("[%s]", oldVersion);
        }

        Cache lookup = new Cache(oldVersion, newVersion);
        if (dpCache.containsKey(lookup)) {
            return dpCache.get(lookup);
        }


        StringBuilder result = new StringBuilder();

        int o = 0, n = 0;
        while (o < oldVersion.length() || n < newVersion.length()) {
            String oldV = o < oldVersion.length() ? "" + oldVersion.charAt(o) : null;
            String newV = n < newVersion.length() ? "" + newVersion.charAt(n) : null;

            if (oldV == null) {
                result.append(String.format("[%s]", newV));
                n++;
            } else if (newV == null) {
                result.append(String.format("(%s)", oldV));
                o++;
            } else if (oldV.equals(newV)) {
                result.append(newV);
                o++;
                n++;
            } else {

                String left = diff(oldVersion.substring(o + 1), newVersion.substring(n), dpCache);
                String right = diff(oldVersion.substring(o), newVersion.substring(n + 1), dpCache);

                if (left.length() > right.length()) {
                    result.append(String.format("[%s]", newV));
                    n++;
                } else {
                    result.append(String.format("(%s)", oldV));
                    o++;
                }
            }
        }

        dpCache.put(new Cache(oldVersion, newVersion), result.toString());
        return result.toString();
    }


    private class Cache {
        private final String _old;
        private final String _new;

        public Cache(String old, String aNew) {
            _old = old;
            _new = aNew;
        }

        @Override
        public int hashCode() {
            return (_old.hashCode() << 7 + (_new.hashCode() * 3)) % Integer.MAX_VALUE;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != Cache.class) {
                return false;
            }
            Cache toCompare = (Cache) obj;
            return getOld().equals(toCompare.getOld()) &&
                    getNew().equals(toCompare.getNew());
        }

        public String getOld() {
            return _old;
        }

        public String getNew() {
            return _new;
        }
    }
}