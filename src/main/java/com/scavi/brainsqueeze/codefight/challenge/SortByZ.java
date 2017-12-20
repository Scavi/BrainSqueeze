package com.scavi.brainsqueeze.codefight.challenge;

import java.util.Arrays;
import java.util.Comparator;

public class SortByZ {
    String[] SortByZ(String[] g, int z) {
        Arrays.sort(g, Comparator.comparingInt(a -> a.toLowerCase().charAt(z - 1)));
        return g;
    }
}