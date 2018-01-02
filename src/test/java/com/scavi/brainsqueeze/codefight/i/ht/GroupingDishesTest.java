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

package com.scavi.brainsqueeze.codefight.i.ht;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class GroupingDishesTest {
    @Test
    public void test1() {
        String[][] input = new String[][]{{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};
        GroupingDishes groupDishes = new GroupingDishes();
        String[][] output = groupDishes.groupingDishes(input);
        String[][] expected = new String[][]{
                {"Cheese", "Quesadilla", "Sandwich"},
                {"Salad", "Salad", "Sandwich"},
                {"Sauce", "Pizza", "Quesadilla", "Salad"},
                {"Tomato", "Pizza", "Salad", "Sandwich"}};

        for (int i = 0; i < expected.length; ++i) {
            for (int j = 0; j < expected[0].length; ++j) {
                assertThat(output[i][j]).isEqualTo(expected[i][j]);
            }
        }
    }


    @Test
    public void test2() {
        String[][] input = new String[][]{{"First", "a", "b", "c", "d", "e", "f", "g", "h", "i"},
                {"Second", "i", "h", "g", "f", "e", "x", "c", "b", "a"}};
        GroupingDishes groupDishes = new GroupingDishes();
        String[][] output = groupDishes.groupingDishes(input);
        String[][] expected = new String[][]{
                {"a", "First", "Second"},
                {"b", "First", "Second"},
                {"c", "First", "Second"},
                {"e", "First", "Second"},
                {"f", "First", "Second"},
                {"g", "First", "Second"},
                {"h", "First", "Second"},
                {"i", "First", "Second"},
        };

        for (int i = 0; i < expected.length; ++i) {
            for (int j = 0; j < expected[0].length; ++j) {
                assertThat(output[i][j]).isEqualTo(expected[i][j]);
            }
        }
    }


    @Test
    public void test3() {
        String[][] input = new String[][]{
                {"Pasta", "Tomato Sauce", "Onions", "Garlic"},
                {"Chicken Curry", "Chicken", "Curry Sauce"},
                {"Fried Rice", "Rice", "Onions", "Nuts"},
                {"Salad", "Spinach", "Nuts"},
                {"Sandwich", "Cheese", "Bread"},
                {"Quesadilla", "Chicken", "Cheese"}
        };
        GroupingDishes groupDishes = new GroupingDishes();
        String[][] output = groupDishes.groupingDishes(input);
        String[][] expected = new String[][]{
                {"Cheese", "Quesadilla", "Sandwich"},
                {"Chicken", "Chicken Curry", "Quesadilla"},
                {"Nuts", "Fried Rice", "Salad"},
                {"Onions", "Fried Rice", "Pasta"},
        };

        for (int i = 0; i < expected.length; ++i) {
            for (int j = 0; j < expected[0].length; ++j) {
                assertThat(output[i][j]).isEqualTo(expected[i][j]);
            }
        }
    }
}
