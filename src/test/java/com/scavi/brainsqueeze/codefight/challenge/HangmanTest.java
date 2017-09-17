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

import org.junit.Assert;
import org.junit.Test;

public class HangmanTest {
    @Test
    public void test1() {
        boolean isValid = new Hangman().hangman("hello", "aenmrolhtg");
        Assert.assertTrue(isValid);
    }

    @Test
    public void test2() {
        boolean isValid = new Hangman().hangman("g", "abcdefgh");
        Assert.assertFalse(isValid);
    }
}
