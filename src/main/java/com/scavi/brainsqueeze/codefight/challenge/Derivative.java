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

/**
 * Created by Scavenger on 6/18/2017.
 */
public class Derivative {
    int derivative(String p, int x) {
        int cPos = search(p, 0, "+", "-");
        int result = calc(p.substring(0, cPos), x);
        while (cPos < p.length() - 1) {
            int lCPos = cPos++;
            cPos = search(p, cPos, "+", "-");
            if (p.charAt(lCPos) == '+') {
                result += calc(p.substring(lCPos + 2, cPos), x);
            } else {
                result -= calc(p.substring(lCPos + 2, cPos), x);
            }
        }
        return result;
    }

    private int calc(String p, int x) {
        if (!p.contains("x")) {
            return 0;
        }
        int exp = 1;
        int coef = p.startsWith("-") ? -1 : 1;
        int pos1 = p.indexOf("*", 0);
        if (pos1 > 0) {
            coef = Integer.parseInt(p.substring(0, pos1));
        }
        int pos2 = p.indexOf("^", pos1);
        if (pos2 > 0) {
            exp = Integer.parseInt(p.substring(pos2 + 1).trim());
        }
        int result = exp == 0 ? 0 : (int) (coef * (exp) * Math.pow(x, exp - 1));
        return result;
    }

    private int search(String p, int from, String l1, String l2) {
        int t1 = p.indexOf(String.format(" %s ", l1), from);
        int t2 = p.indexOf(String.format(" %s ", l2), from);
        int r;
        if (t1 > 0 && t2 > 0) {
            r = Math.min(t1, t2);
        } else {
            r = t1 > 0 ? t1 : t2;
        }
        return r == -1 ? p.length() : r + 1;
    }
}
