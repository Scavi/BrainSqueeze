package com.scavi.brainsqueeze.career;

import com.google.common.hash.HashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RedWhiteJar {
    private int _redBeans;
    private int _whiteBeans;

    public RedWhiteJar(int redBeans, int whiteBeans) {
        _redBeans = redBeans;
        _whiteBeans = whiteBeans;
    }

    public double probabilityLastWhite() {
        return probabilityLastWhite(_redBeans, _whiteBeans, false, null);
    }

    private double probabilityLastWhite(
            final double redBeans,
            final double whiteBeans,
            final boolean isLastRedPutBack,
            final Map<Cache, Double> dpCache) {
        if (whiteBeans == 0) {
            return 0;
        } else if (redBeans == 0) {
            return 1;
        }
        Cache lookup = new Cache(whiteBeans, redBeans, isLastRedPutBack);
        if (dpCache != null && dpCache.containsKey(lookup)) {
            return dpCache.get(lookup);
        }
        double probWhite = probabilityLastWhite(redBeans, whiteBeans - 1, false, dpCache);
        double probRed = isLastRedPutBack ?
                probabilityLastWhite(redBeans - 1, whiteBeans, false, dpCache) :
                probabilityLastWhite(redBeans, whiteBeans, true, dpCache);
        double prob = (whiteBeans / (whiteBeans + redBeans) * probWhite) +
                (redBeans / (whiteBeans + redBeans) * probRed);
        if (dpCache != null) {
            dpCache.put(lookup, prob);
        }
        return prob;
    }


    public double probabilityLastWhiteDP() {
        Map<Cache, Double> cache = new HashMap<>();
        return probabilityLastWhite(_redBeans, _whiteBeans, false, cache);
    }


    private class Cache {
        private final double _whiteBeans;
        private final double _redBeans;
        private final boolean _isLastRedPutBack;

        public Cache(final double whiteBeans, final double redBeans, final boolean isLastRedPutBack) {
            _whiteBeans = whiteBeans;
            _redBeans = redBeans;
            _isLastRedPutBack = isLastRedPutBack;
        }

        @Override
        public int hashCode() {
            return Objects.hash(_whiteBeans, _redBeans, _isLastRedPutBack);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != Cache.class) {
                return false;
            }
            Cache toCompare = (Cache) obj;
            return _whiteBeans == toCompare._whiteBeans &&
                    _redBeans == toCompare._redBeans &&
                    _isLastRedPutBack == toCompare._isLastRedPutBack;
        }
    }
}
