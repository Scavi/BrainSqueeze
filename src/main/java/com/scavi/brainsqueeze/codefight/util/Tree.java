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

package com.scavi.brainsqueeze.codefight.util;

// Definition for binary tree:
public class Tree<T> {
    public Tree(T x) {
        value = x;
    }

    public T value;
    public Tree<T> left;
    public Tree<T> right;

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
