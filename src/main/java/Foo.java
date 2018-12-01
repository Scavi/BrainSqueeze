import com.google.common.primitives.Ints;
import com.scavi.brainsqueeze.util.Node;
import com.scavi.brainsqueeze.util.Point;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.*;

public class Foo {


    public boolean exists(char[][] dungeon, Point start, Point target) {
        boolean[][] visited = new boolean[dungeon.length][dungeon[0].length];
        return move(dungeon, visited, start.getX(), start.getY(), target);
    }


    private boolean move(char[][] dungeon, boolean[][] visited, int currentX, int currentY, Point target) {
        if (currentX < 0 || currentY < 0 || currentX >= dungeon[0].length || currentY >= dungeon.length ||
                visited[currentY][currentX]) {
            return false;
        } else if (currentX == target.getX() && currentY == target.getY()) {
            return true;
        }
        visited[currentY][currentX] = true;
        boolean found = move(dungeon, visited, currentX + 1, currentY, target);
        found |= move(dungeon, visited, currentX - 1, currentY, target);
        found |= move(dungeon, visited, currentX, currentY + 1, target);
        found |= move(dungeon, visited, currentX, currentY - 1, target);
        return found;
    }

    private static void crackPw(final String pw) {
        try {
            File file = new File("/home/scavenger/users/keystores/gw2-imp-release-key.keystore");
            FileInputStream is = new FileInputStream(file);
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(is, pw.toCharArray());
            System.out.println("yay!");
        } catch (java.io.IOException | NoSuchAlgorithmException | KeyStoreException | CertificateException ex) {
            System.err.println();
        }


    }


    public static void main(String[] args) {

        Object
        Hashtable<String, Integer> test = new Hashtable<>(10);
        test.insert("foo", 10);
        test.insert("bar", 20);
        test.insert("cookie", 42);

        test.insert("keks1", 20);

        boolean is1 = test.exists("foo");
        boolean is2 = test.exists("keks1");
        boolean is3 = test.exists("foo3");


        HashMap<String, Integer> test2 = new HashMap<>();
        test2.put("cookie", 42);

        byte[] b = new byte[3];
        b[2] <<= 1;

        Comparator<Integer> comparator = (x, y) -> y - x;

        //Comparator<Integer> comparator = Comparator.comparingInt(o1 -> o1);

        if (comparator.compare(1, 2) < 0) {
            System.out.println("");
        }

        LinkedHashMap<Integer, Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put(1, null);
        linkedMap.put(2, null);
        linkedMap.put(3, null);
        linkedMap.put(4, null);
        linkedMap.put(5, null);
        linkedMap.put(10, null);
        linkedMap.put(9, null);
        linkedMap.put(8, null);
        linkedMap.put(7, null);

        for (Map.Entry<Integer, Integer> it : linkedMap.entrySet()) {
            System.out.println(it.getKey());
        }


        int[] o = warmerDays(new int[]{14, 17, 16, 15, 18});


        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n7 = new Node<>(7);

        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n6.setRight(n7);

        printLevel(n1);

        System.out.println();
    }


    private static int[] warmerDays(@Nonnull int[] input) {
        int[] output = new int[input.length];
        Arrays.fill(output, -1);
        if (output.length < 2) {
            return output;
        }


        PriorityQueue<Integer> temp = new PriorityQueue<>((o1, o2) -> o2 - o1);
        temp.add(0);

        for (int i = 1; i < input.length; ++i) {
            while (!temp.isEmpty() && input[temp.peek()] < input[i]) {
                output[temp.peek()] = i - temp.poll();
            }
            temp.add(i);
        }
        return output;
    }


    private static void printLevel(Node<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<Node<Integer>> odd = new LinkedList<>();
        Queue<Node<Integer>> even = new LinkedList<>();

        odd.add(root);

        while (!odd.isEmpty() || !even.isEmpty()) {
            while (!odd.isEmpty()) {
                Node<Integer> current = odd.poll();
                System.out.print(current.getValue());
                if (current.getLeft() != null) {
                    even.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    even.add(current.getRight());
                }
            }
            System.out.println();
            while (!even.isEmpty()) {
                Node<Integer> current = even.poll();
                System.out.print(current.getValue());
                if (current.getLeft() != null) {
                    odd.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    odd.add(current.getRight());
                }
            }
            System.out.println();
        }

    }


    public static LinkedList<LinkedList<Integer>> create(int rows, int columns) {
        LinkedList<LinkedList<Integer>> data = new LinkedList<>();
        for (int i = 0; i < rows; ++i) {
            LinkedList<Integer> newList = new LinkedList<>();
            for (int j = 0; j < columns; ++j) {
                newList.add(0);
            }
            data.add(newList);
        }
        return data;
    }

    private static class IOException {
    }
}
