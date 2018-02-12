package com.scavi.brainsqueeze.codefight.i.dfsbfs;

import com.scavi.brainsqueeze.codefight.util.Tree;

public class DigitTreeSum {


    long digitTreeSum(Tree<Integer> t) {
        //return digitTreeSum(t, new Stack<>());
        return 0;
    }


//    long digitTreeSum(Tree<Integer> t) {
//        return digitTreeSum(t, new Stack<>());
//    }
//
//
//    private long digitTreeSum(Tree<Integer> t, Stack<Integer> pathValues) {
//        if (t == null || t.value == null) {
//            return 0;
//        }
//        pathValues.push(t.value);
//        if (t.right == null && t.left == null) {
//            return from(pathValues);
//        }
//        long result = digitTreeSum(t.left, pathValues) + digitTreeSum(t.right, pathValues);
//        pathValues.pop();
//        return result;
//    }
//
//
//    private long from(Stack<Integer> pathValues) {
//        long result = 0;
//        int exp = pathValues.size() - 1;
//        for (Integer value : pathValues) {
//            result += value * Math.pow(10, exp);
//            exp--;
//        }
//        return result;
//    }


//    long digitTreeSum(Tree<Integer> t) {
//        return digitTreeSum(t, "");
//    }
//
//
//    private long digitTreeSum(Tree<Integer> t, String tmp) {
//        if (t == null || t.value == null) {
//            return Long.parseLong(tmp);
//        }
//        else if (t.left == null && t.right == null) {
//            return Long.parseLong(tmp + t.value);
//        }
//        return digitTreeSum(t.left, tmp + String.valueOf(t.value)) +
//                digitTreeSum(t.right, tmp + String.valueOf(t.value));
//    }

}
