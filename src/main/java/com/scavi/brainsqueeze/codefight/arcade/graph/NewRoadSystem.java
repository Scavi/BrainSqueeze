package com.scavi.brainsqueeze.codefight.arcade.graph;

public class NewRoadSystem {
    private final int OUT = 0;
    private final int IN = 1;

    /**
     * Once upon a time, in a kingdom far, far away, there lived a king Byteasar I. As a kind and wise ruler, he did
     * everything in his (unlimited) power to make life of his subjects comfortable and pleasant. One cold evening a
     * messenger arrived to the king's castle with the latest news: all kings in the Kingdoms Union started to
     * enforce traffic laws! In order not to lose his membership in the Union, king Byteasar had to do the same in
     * his kingdom. But what would the citizens think of it?
     * <p>
     * The king decided to start introducing the changes with something more or less simple: change all the roads in
     * the kingdom from two-directional to one-directional. He personally prepared the roadRegister of the new roads,
     * and now he needs to make sure that the road system is convenient and there will be no traffic jams, i.e. each
     * city has the same number of incoming and outgoing roads. As the Hand of the King, you're the one who should
     * check it.
     *
     * @param roadRegister the road registration
     * @return <code>true</code> the road registration is valid <br/>
     * <code>false</code> not valid
     */
    boolean newRoadSystem(boolean[][] roadRegister) {
        int[][] cities = new int[roadRegister.length][2];

        for (int y = 0; y < roadRegister.length; ++y) {
            for (int x = 0; x < roadRegister[0].length; ++x) {
                if (roadRegister[y][x]) {
                    cities[y][OUT]++;
                    cities[x][IN]++;
                }
            }
        }

        for (int[] city : cities) {
            if (city[OUT] != city[IN]) {
                return false;
            }
        }
        return true;
    }

}
