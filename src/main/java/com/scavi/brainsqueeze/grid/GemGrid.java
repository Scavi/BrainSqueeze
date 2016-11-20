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

package com.scavi.brainsqueeze.grid;

import com.google.common.base.Preconditions;
import com.scavi.brainsqueeze.util.Point;

/**
 * @author Michael Heymel
 * @since 23/09/16
 */
public class GemGrid {

    /**
     * There is a 2D grid and there are two players P1 and P2. Their x,y positions are given. Then
     * there are N gems on the gird and their positions are also given. The two players together are
     * supposed to collect the games in the given sequence making minimum moves (movement in all 8
     * directions is considered as 1 move)
     * <p/>
     * Note: the gems should be collected in the given order by either one of the players and then
     * their position becomes the new position
     *
     * @param positionPlayer1 the position of player 1
     * @param positionPlayer2 the position of player 2
     * @param gems            the position of all gems
     * @return the minimum moves
     */
    public int determineMinimumMoves(Point positionPlayer1, Point positionPlayer2,
            final Point... gems) {
        Preconditions.checkNotNull(positionPlayer1, "The position of player 1 is null");
        Preconditions.checkNotNull(positionPlayer2, "The position of player 2 is null");

        int moves = 0;
        if (gems != null) {
            for (Point gemPosition : gems) {
                final int distancePlayer1ToGem = positionPlayer1.distanceTo(gemPosition);
                final int distancePlayer2ToGem = positionPlayer2.distanceTo(gemPosition);

                // player 2 is closer - move player 2
                if (distancePlayer1ToGem > distancePlayer2ToGem) {
                    positionPlayer2 = gemPosition;
                }
                // player 1 is closer or distance is equal - move player 1
                else {
                    positionPlayer1 = gemPosition;
                }
                moves += Math.min(distancePlayer1ToGem, distancePlayer2ToGem);
            }
        }
        return moves;
    }
}
