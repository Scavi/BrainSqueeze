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

package com.scavi.brainsqueeze.career;

import com.scavi.brainsqueeze.util.graph.Graph;
import org.junit.Test;

/**
 * Created by Scavenger on 5/13/2017.
 */
public class CompanyShareTest {

    /**
     * A - 10% -> B - 2% -> C => 0.2%
     */
    @Test
    public void test1() {
        Graph<Character> graph = new Graph<>();
        graph.addEdge('A', 'B', 10);
        graph.addEdge('B', 'C', 2);
    }
}
