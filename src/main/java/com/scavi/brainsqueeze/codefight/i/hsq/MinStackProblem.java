package com.scavi.brainsqueeze.codefight.i.hsq;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MinStackProblem {


    int[] minimumOnStack(String[] operations) {
        List<Integer> result = new LinkedList<>();
        MinStack minStack = new MinStack();
        for (String operation : operations) {
            if (operation.equals("min")) {
                result.add(minStack.getMin());
            } else if (operation.equals("pop")) {
                minStack.pop();
            } else if (operation.startsWith("push")) {
                minStack.push(Integer.parseInt(operation.substring(5, operation.length())));
            } else {
                throw new IllegalArgumentException(operation);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }


    public class MinStack {
        private int min;
        private final Stack<Integer> stack = new Stack<>();

        void push(int x) {
            if (stack.isEmpty()) {
                stack.push(0);
                min = x;
            } else {
                stack.push(x - min);
                if (x < min) {
                    min = x;
                }
            }
        }

        int pop() throws RuntimeException {
            if (stack.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            int tmp = stack.pop();
            int res;
            if (tmp < 0) {
                res = min;
                min -= tmp;
            } else {
                res = tmp + min;
            }
            return res;
        }


        int getMin() {
            return min;
        }
    }
}
