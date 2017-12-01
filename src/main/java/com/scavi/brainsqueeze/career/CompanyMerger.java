package com.scavi.brainsqueeze.career;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class CompanyMerger {
    /**
     * Give a list of the company's Mergers and Acquisitions relationships, for example
     * [
     * ["baidu", "ofo"],
     * ["mobike", "alibaba"],
     * ]
     * Said baidu acquired ofo, mobike acquired Alibaba.
     * Seeking the longest of a M & A chain. No cycle
     * <p>
     * <p>
     * The worst case runtime behaviour is O(n * m) while n is the number of key-entries in the relationship and m
     * the number of relationships between the companies.
     * This algorithm uses an additional cache to store already calculated distance of relationships. It reduces
     * the recursive calls if we have a company multiple times (e.g. in test1 mobike->alibaba->somethingElse (2)
     * and cookies->mobike reuses the calculated value of 2).
     *
     * @param relationships the map with relationships
     * @return the longest chain
     */
    public int longestChain(@Nonnull Map<String, String> relationships) {
        int count = 0;
        Map<String, Integer> cache = new HashMap<>();
        for (Map.Entry<String, String> relationship : relationships.entrySet()) {
            count = Math.max(count, longestChain(relationships, cache, relationship.getKey()));
        }
        return count;
    }


    private int longestChain(@Nonnull Map<String, String> relationships, Map<String, Integer> cache, String lookup) {
        int count = 0;
        if (cache.containsKey(lookup)) {
            count = cache.get(lookup);
        } else if (relationships.containsKey(lookup)) {
            String newLookup = relationships.get(lookup);
            count = 1 + longestChain(relationships, cache, newLookup);
            cache.put(lookup, count);
        }
        return count;
    }

}
