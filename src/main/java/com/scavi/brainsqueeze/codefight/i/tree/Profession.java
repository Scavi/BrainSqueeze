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

package com.scavi.brainsqueeze.codefight.i.tree;

public class Profession {
    private static final String ENGINEER = "Engineer";
    private static final String DOCTOR = "Doctor";

    String findProfession(int level, int pos) {

        Move[] moves = new Move[level - 1];
        for (int i = moves.length - 1; i >= 0; --i) {
            if (pos % 2 == 0) {
                moves[i] = Move.Right;
                pos = pos > 1 ? pos / 2 : 1;
            } else {
                moves[i] = Move.Left;
                pos = pos > 1 ? (pos / 2) + 1 : 1;
            }
            level--;
        }


        String retVal = ENGINEER;
        for (Move move : moves) {
            if (retVal.equals(ENGINEER)) {
                retVal = move == Move.Left ? ENGINEER : DOCTOR;
            } else {
                retVal = move == Move.Left ? DOCTOR : ENGINEER;
            }
        }
        return retVal;
    }


    private enum Move {
        Left, Right
    }


//    String findProfession(int level, int pos) {
//        if (level == 1) {
//            return ENGINEER;
//        }
//        _level = level;
//        _pos = pos;
//        return search(ENGINEER, 1, 1);
//    }
//
//
//    private String search(String root, int currentLevel, int currentPos) {
//        if (currentLevel > _level) {
//            return null;
//        }
//        if (_level == currentLevel && _pos == currentPos) {
//            return root;
//        }
//        ++currentLevel;
//
//        // left
//        String retVal = search(
//                root.equals(ENGINEER) ? ENGINEER : DOCTOR,
//                currentLevel,
//                (currentPos * 2) - 1);
//        if (retVal == null) {
//            retVal = search(
//                    root.equals(ENGINEER) ? DOCTOR : ENGINEER,
//                    currentLevel,
//                    currentPos * 2);
//        }
//        return retVal;
//    }
}
