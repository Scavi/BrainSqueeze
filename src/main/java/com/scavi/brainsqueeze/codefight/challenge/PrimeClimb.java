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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Scavenger on 6/18/2017.
 */
public class PrimeClimb {

    String primeClimb(int n) {
        Map<Integer, Integer> expCache = new HashMap<>();
        List<Integer> primes = new ArrayList<>();
        while ((n % 2) == 0) {
            add(2, primes, expCache);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); ++i) {
            while ((n % i) == 0) {
                add(i, primes, expCache);
                n /= i;
            }
        }
        if (n > 2) {
            primes.add(n);
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < primes.size(); ++i) {
            int ex = expCache.getOrDefault(primes.get(i), 0);
            res.append(primes.get(i)).append((ex > 1 ? "" + ex : ""));
        }
        return res.toString();
    }

    private void add(int v, List<Integer> primes, Map<Integer, Integer> expCache) {
        if (!expCache.containsKey(v)) {
            primes.add(v);
        }
        expCache.put(v, expCache.containsKey(v) ? expCache.get(v) + 1 : 1);
    }
}
