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

package com.scavi.brainsqueeze.adventofcode.y2016;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Question: http://adventofcode.com/2016/day/20
 *
 * @author Michael Heymel
 * @since 19/12/16
 */
public class Day19AnElephantNamedJoseph {
    /**
     * This methods determines the position of the last person while removing the participants left
     * from the current
     *
     * @param participantCount the number of participants
     * @return the position of the left participant
     */
    public int whoHasThePresentLeft(final int participantCount) {
        Preconditions.checkArgument(participantCount > 0,
                "Illegal participant count. Higher than 0 expected");
        int presentPos = 0;
        int[] participants = new int[participantCount];
        Arrays.fill(participants, 1);
        int position = 0;
        int presentsLeft = participantCount;
        while (presentsLeft > 1) {
            int currentPosition = position % participantCount;
            if (participants[currentPosition] > 0) {
                int next = currentPosition + 1;
                while (participants[next % participantCount] == 0) {
                    next++;
                }
                next = next % participantCount;
                participants[currentPosition] += participants[next];
                participants[next] = 0;
                --presentsLeft;
                presentPos = currentPosition;
            }
            position++;
        }
        return presentPos + 1; // +1 because the positions are 0 based
    }


    /**
     * This methods determines the position of the last person while removing the participants on
     * the opposite site from the current participant
     *
     * @param participantCount the number of participants
     * @return the position of the left participant
     */
    public int whoHasThePresentOpposite(final int participantCount) {
        Preconditions.checkArgument(participantCount > 0,
                "Illegal participant count. Higher than 0 expected");
        List<Integer> participants = createParticipantsList(participantCount);
        int activePosition = 0;
        int kickMovement = ((participants.size() / 2) + activePosition) % participants.size();
        Iterator<Integer> playerToKick = participants.iterator();
        do {
            playerToKick = move(participants, playerToKick, kickMovement);
            playerToKick.remove();
            activePosition = (activePosition + 1) % participants.size();
            kickMovement = participants.size() % 2 == 0 ? 1 : 0;
        }
        while (participants.size() > 1);
        return participants.get(0);
    }


    /**
     * Moves the iterator the specified move count. In case the iterator reaches it's end, a new one
     * will be created based on the current participant list
     *
     * @param participantList the current participant list
     * @param iterator        the current iterator
     * @param moveCount       the number to move the iterator
     * @return the moved iterator
     */
    private Iterator<Integer> move(List<Integer> participantList, Iterator<Integer> iterator,
            int moveCount) {
        while (moveCount >= 0) {
            if (!iterator.hasNext()) {
                iterator = participantList.iterator();
            }
            iterator.next();
            moveCount--;
        }
        return iterator;
    }


    /**
     * Creates a linked list of participants with their corresponding position
     *
     * @param participantCount the number of participants
     * @return the linked list with the participants
     */
    private List<Integer> createParticipantsList(final int participantCount) {
        List<Integer> participants = new LinkedList<>();
        for (int i = 0; i < participantCount; ++i) {
            participants.add(i + 1);
        }
        return participants;
    }
}
