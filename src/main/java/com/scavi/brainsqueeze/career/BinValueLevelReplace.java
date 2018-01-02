package com.scavi.brainsqueeze.career;

public class BinValueLevelReplace {

    /**
     * 0 change to 01,1 change to 10.
     * Line 0 is 0, the first line is 01, the second line is 0110, the third line 01101001. . . Keep asking what is
     * the vale at kth row and jth col
     * <br/>
     * This algorithm runs in O(n) (while row is n) and uses O(1) space. Basically this is a log approach.
     *
     * @param row    the target row
     * @param column the target column
     * @return <code>true</code> if the value is 1 at row / column, otherwise <code>false</code>
     */
    public boolean isSet(int row, final int column) {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException("Illegal input! Row and column position must be positive!");
        } else if (row == 0) {
            return false;
        } else if ((int) Math.pow(row, 2) < column) {
            throw new IllegalArgumentException("Illegal input! Column is out of range!");
        }

        int left = 0;
        int right = (int) Math.pow(row, 2);
        boolean isValue = false;
        while (row-- > 0) {
            int mid = (right + left) / 2;
            // go left
            if (left <= column && mid > column) {
                right = mid;
            }
            // go right
            else {
                left = mid;
                isValue = !isValue;
            }
        }
        return isValue;
    }
}
