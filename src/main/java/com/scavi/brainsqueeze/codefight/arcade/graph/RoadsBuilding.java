package com.scavi.brainsqueeze.codefight.arcade.graph;

import com.scavi.brainsqueeze.codefight.util.GraphHelper;

public class RoadsBuilding {
    /**
     * Once upon a time, in a kingdom far, far away, there lived a king Byteasar II. There was nothing special
     * neither about him, nor about his kingdom. As a mediocre ruler, he did nothing about his kingdom and preferred
     * hunting and feasting over doing anything about his kingdom prosperity.
     * <p>
     * Luckily, his adviser, wise magician Bitlin, was working for the kingdom welfare daily and nightly. However,
     * since there was no one to advise him, he completely forgot about one important thing: the roads. Over the
     * years most of the two-way roads built by Byteasar II predecessors were forgotten and no longer traversable.
     * Only a few roads can still be used.
     * <p>
     * Bitlin wanted each pair of cities to be connected, but couldn't find a way to figure out which roads are
     * missing. Desperate, he turned to his magic crystal, seeking help. The crystal showed him a programmer from the
     * distant future: you! Now you're the only one who can save the kingdom. Given the existing roads and the number
     * of cities in the kingdom, you should use the most modern technologies and find out what roads should be built
     * again to make each pair of cities connected. Since the magic crystal is quite old and meticulous, it will only
     * transfer the information that is sorted properly.
     * <p>
     * The roads to be built should be returned in an array sorted lexicographically, with each road stored as
     * [cityi, cityj], where cityi < cityj.
     *
     * @param cities the amount of cities
     * @param roads  the roads that connect the cities
     * @return the roads that are required to build
     */
    int[][] roadsBuilding(int cities, int[][] roads) {
        boolean[][] matrix = GraphHelper.fromCitiesAndRoads(cities, roads);
        int n = cities - 1;
        int requiredStreets = ((n * (n + 1)) / 2) - roads.length;
        int[][] roadsToBuild = new int[requiredStreets][2];

        int r = 0;
        for (int y = 0; y < matrix.length; ++y) {
            for (int x = y + 1; x < matrix[0].length; ++x) {
                if (!matrix[y][x]) {
                    roadsToBuild[r] = new int[]{y, x};
                    r++;
                }
            }
        }
        return roadsToBuild;
    }
}
