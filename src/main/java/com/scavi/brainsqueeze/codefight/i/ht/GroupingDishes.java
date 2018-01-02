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

import java.util.*;

public class GroupingDishes {
    String[][] groupingDishes(String[][] dishes) {
        if (dishes == null || dishes.length == 0 || dishes[0].length == 0) {
            return null;
        }
        Map<String, Set<String>> groupedDishes = new TreeMap<>();
        for (String[] dishIngredients : dishes) {
            for (int i = 1; i < dishIngredients.length; ++i) {
                String dish = dishIngredients[0];
                String ingredient = dishIngredients[i];
                if (groupedDishes.containsKey(ingredient)) {
                    Set<String> ingredients = groupedDishes.get(ingredient);
                    if (!ingredients.contains(dish)) {
                        ingredients.add(dish);
                    }
                } else {
                    Set<String> knownDishes = new TreeSet<>();
                    knownDishes.add(dish);
                    groupedDishes.put(ingredient, knownDishes);
                }
            }
        }
        return dishesToStringArray(groupedDishes);
    }


    private String[][] dishesToStringArray(Map<String, Set<String>> groupedDishes) {
        groupedDishes.entrySet().removeIf(stringSetEntry -> stringSetEntry.getValue().size() < 2);
        String[][] ingredientsToDishes = new String[groupedDishes.size()][];
        int y = 0;
        for (Map.Entry<String, Set<String>> groupedDish : groupedDishes.entrySet()) {
            ingredientsToDishes[y] = new String[groupedDish.getValue().size() + 1];
            ingredientsToDishes[y][0] = groupedDish.getKey();
            int x = 1;
            for (String dish : groupedDish.getValue()) {
                ingredientsToDishes[y][x] = dish;
                x++;
            }
            y++;
        }
        return ingredientsToDishes;
    }
}
