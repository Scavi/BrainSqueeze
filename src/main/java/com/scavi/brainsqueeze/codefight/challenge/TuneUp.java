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

public class TuneUp {

    String tuneUp(double f) {
        return new String[]{"A", "Bb", "B", "C", "C#", "D", "Eb", "E", "F", "F#", "G", "Gb"}[(((int) Math.round((12 * (Math.log(f / 440.0) / Math.log(2))) + 49) % 12)) - 1];
    }
}
