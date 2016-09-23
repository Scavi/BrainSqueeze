package com.scavi.brainsqueeze.general;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Michael Heymel on 18/09/16.
 */
public class ListGames {

    /**
     * Given two sorted lists and an integer max, merge the lists up to the maximum of the max
     * elements
     *
     * @param list1 the list 1
     * @param list2 the list 2
     * @param max   the maximum number
     * @return the merged list
     */
    public <T extends Comparable<T>> List<T> merge(List<T> list1, List<T> list2, final int max) {
        if (list1 == null) {
            list1 = new ArrayList<>(0);
        }
        if (list2 == null) {
            list2 = new ArrayList<>(0);
        }

        List<T> resultList = new ArrayList<>(max);
        int list1Pos = 0;
        int list2Pos = 0;
        for (int i = 0; i < max; ++i) {

            T value = null;
            if (list1Pos < list1.size() && list2Pos < list2.size()) {
                if (list1.get(list1Pos).compareTo(list2.get(list2Pos)) < 0) {
                    value = list1.get(list1Pos++);
                } else {
                    value = list2.get(list2Pos++);
                }
            } else if (list1Pos < list1.size()) {
                value = list1.get(list1Pos++);
            } else if (list2Pos < list2.size()) {
                value = list2.get(list2Pos++);
            }
            resultList.add(value);
        }
        return resultList;
    }
}
