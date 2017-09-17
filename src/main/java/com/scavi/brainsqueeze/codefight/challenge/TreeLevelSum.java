/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scavi.brainsqueeze.codefight.challenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Scavenger on 6/15/2017.
 */
// TODO
public class TreeLevelSum {

    public int treeLevelSum(String tree, int k) {
        Node root = Node.from(tree);
        return Node.levelOrderSum(root, k);
    }

    private final static class Node {
        private static Pattern _searchNum = Pattern.compile("[^\\(]*");
        private final int value;
        private Node left;
        private Node right;

        public Node(final String value, int pos) {
            this(Integer.parseInt(identifyNumber(value, pos)));
        }

        public Node(final int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public static Node from(String treeString) {
            if (treeString == null || treeString.length() < 3) {
                return null;
            }
            Node root = new Node("1", 1);
            from(root, treeString, 2);
            return root;
        }

        private static void from(Node root, String treeString, int index) {

        }


        private static String findSubtree(String string, int startIndex) {
            int currentIndex = startIndex;
            int open = 1;
            while (open > 0) {
                if (string.charAt(currentIndex) == '(') {
                    open++;
                } else if (string.charAt(currentIndex) == ')') {
                    open--;
                }
                currentIndex++;
            }
            return string.substring(startIndex, currentIndex);
        }

        private static String identifyNumber(String string, int pos) {
            Matcher searchMatcher = _searchNum.matcher(string);
            return searchMatcher.find(pos) ? searchMatcher.group(0) : null;
        }


        public static int levelOrderSum(Node root, int level) {
            if (root == null) {
                return 0;
            }
            int sum = levelOrderSum(root.getLeft(), level - 1);
            sum = levelOrderSum(root.getRight(), level - 1);
            return sum;
        }

    }
}
