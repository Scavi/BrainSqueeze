package com.scavi.brainsqueeze.codefight.i.hsq;

public class CloudCount {
    int countClouds(final char[][] skyMap) {
        int cloudCount = 0;
        if (skyMap == null || skyMap.length == 0 || skyMap[0].length == 0) {
            return cloudCount;
        }

        boolean[][] searched = new boolean[skyMap.length][skyMap[0].length];
        for (int y = 0; y < skyMap.length; ++y) {
            for (int x = 0; x < skyMap[0].length; ++x) {
                if (skyMap[y][x] == '1' && !searched[y][x]) {
                    follow(skyMap, searched, x, y);
                    cloudCount++;
                }
            }
        }
        return cloudCount;
    }


    private void follow(final char[][] skyMap, final boolean[][] searched, final int x, final int y) {
        if (x < 0 || x >= searched[0].length ||
                y < 0 || y >= searched.length ||
                searched[y][x] ||
                skyMap[y][x] == '0') {
            return;
        }
        searched[y][x] = true;
        follow(skyMap, searched, x + 1, y);
        follow(skyMap, searched, x - 1, y);
        follow(skyMap, searched, x, y + 1);
        follow(skyMap, searched, x, y - 1);
    }
}
