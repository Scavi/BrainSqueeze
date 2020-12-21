package com.scavi.brainsqueeze.adventofcode

import java.lang.StringBuilder

class Day21AllergenAssessment {
    private val splitPattern = """([^\(]*)(\(contains\s)([^\)]*)""".toRegex()
    private data class Food(
            val allIngredients: MutableMap<String, Int>,
            val allergenToIngredients: MutableMap<String, MutableSet<String>>)

    fun solveA(input: List<String>): Int {
        val food = filter(prepare(input))
        return food.allIngredients.values.sum()
    }

    fun solveB(input: List<String>): String {
        val food = filter(prepare(input))
        val tmp = StringBuilder()
        for (k in food.allergenToIngredients.keys.sorted()) {
            tmp.append(food.allergenToIngredients[k]!!.first()).append(",")
        }
        return tmp.toString().substring(0, tmp.length - 1)
    }

    private fun prepare(input: List<String>): Food {
        val allIngredients = mutableMapOf<String, Int>()
        val allergenToIngredients = mutableMapOf<String, MutableSet<String>>()
        for (line in input) {
            val (tmpIngredients, _, allergens) = splitPattern.find(line)!!.destructured
            val ingredients = tmpIngredients.trim().split(" ").toHashSet()
            for (ingredient in ingredients) {
                allIngredients[ingredient] = allIngredients.getOrDefault(ingredient, 0) + 1
            }
            for (tmpAllergen in allergens.split(",")) {
                val allergen = tmpAllergen.trim()
                if (allergen in allergenToIngredients) {
                    allergenToIngredients[allergen] = allergenToIngredients[allergen]!!.intersect(ingredients).toMutableSet()
                } else {
                    allergenToIngredients[allergen] = ingredients
                }
            }
        }
        return Food(allIngredients, allergenToIngredients)
    }

    private fun filter(food: Food): Food {
        var hasChanges = true
        while (hasChanges) {
            hasChanges = false
            for ((k1, v1) in food.allergenToIngredients) {
                if (v1.size == 1) {
                    for ((k2, v2) in food.allergenToIngredients) {
                        if (k2 != k1) {
                            hasChanges = hasChanges or v2.removeAll(v1)
                        }
                    }
                }
            }
        }
        for ((_, v) in food.allergenToIngredients) {
            food.allIngredients.remove(v.first())
        }
        return food
    }
}
