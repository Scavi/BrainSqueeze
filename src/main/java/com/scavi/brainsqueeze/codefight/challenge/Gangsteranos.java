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

import java.util.*;

/**
 * Created by Scavenger on 6/19/2017.
 */
public class Gangsteranos {
    boolean theFather(String[] haters) {
        Map<String, N> f = new HashMap<>();
        for (String h : haters) {
            String n1 = h.split("\\s")[0];
            String n2 = h.split("\\s")[1];
            N htr = f.getOrDefault(n1, new N(n1));
            N htd = f.getOrDefault(n2, new N(n2));
            htr.htg.add(htd);
            f.put(htr.na, htr);
            f.put(htd.na, htd);
        }

        List<N> g = new ArrayList<>(f.values());

        boolean v = true;
        for (int i = 0; i < g.size(); ++i) {
            v = true;
            for (N n : g) {
                n.col = C.U;
            }

            for (int j = 0; j < g.size() && v; ++j) {
                N n = g.get(i % g.size());
                if (n.col == C.U) {
                    v = c(n, C.R, C.B);
                }
            }
        }
        return v;
    }


    private boolean c(N n, C c1, C c2) {
        n.col = c1;
        for (N h : n.htg) {
            if (h.col == c1) {
                return false;
            } else if (h.col == C.U) {
                return c(h, c2, c1);
            }
        }
        return true;
    }


    enum C {
        R, B, U
    }

    class N {
        C col = C.U;
        String na;
        List<N> htg = new ArrayList<>();

        N(String n) {
            na = n;
        }


        @Override
        public String toString() {
            return na;
        }
    }
}
