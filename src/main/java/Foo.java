import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Foo {

    public static void main(final String[] args) {

    }


    static int[][] climbingStaircase(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        int[] path = new int[n];
        climbingStaircase(result, path, 0, n, k);
        return from(result);
    }


    private static int[][] from(final List<List<Integer>> toConvert) {
        int[][] result = new int[toConvert.size()][];

        int i = 0;
        for (List<Integer> current : toConvert) {
            result[i] = new int[current.size()];
            for (int j = 0; j < current.size(); ++j) {
                result[i][j] = current.get(j);
            }
        }
        return result;
    }

    private static void climbingStaircase(
            final List<List<Integer>> result,
            final int[] path,
            final int pos,
            final int n,
            final int k) {
        if (n < 0) {
            return;
        } else if (n == 0) {
            List<Integer> tmp = Arrays.stream(path).boxed().collect(Collectors.toList());
            result.add(tmp);
        }

        for (int i = 1; i <= k; ++i) {
            path[pos] = i;
            climbingStaircase(result, path, pos + 1, n - i, k);
        }
    }
}