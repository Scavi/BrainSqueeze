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
import com.scavi.brainsqueeze.util.Pair;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Question: http://adventofcode.com/2016/day/22
 *
 * @author Michael Heymel
 * @since 25/12/16
 */
public class Day22GridComputing {
    private final Pattern _xPosPattern = Pattern.compile("(?<=\\-x)\\d*");
    private final Pattern _yPosPattern = Pattern.compile("(?<=\\-y)\\d*");


    public int viablePairs(final String[] fileSystemInformation) {
        Preconditions.checkNotNull(fileSystemInformation, "Illegal file system input: <null>");
        Pair<Integer, Integer> maxData = maxData(fileSystemInformation);
        NodeInfo[][] fileSystem = from(fileSystemInformation, maxData.getKey(), maxData.getValue());
        int viablePairs = 0;
        for (int i = 0; i < fileSystemInformation.length; ++i) {
            int yToCompare = i / maxData.getKey();
            int xToCompare = i % maxData.getValue();
            NodeInfo toCompare = fileSystem[yToCompare][xToCompare];
            for (int y = yToCompare; y < fileSystem.length; ++y) {
                for (int x = xToCompare; x < fileSystem[0].length; ++x) {
                    if (isViablePair(toCompare, fileSystem[y][x])) {
                        viablePairs++;
                    }

                }
            }
        }
        return viablePairs;
    }


    private boolean isViablePair(final NodeInfo node1, final NodeInfo node2) {
        if (node1 == node2) {
            return false;
        }
        return node1._used != 0 && node1._used <= node2._available;
    }


    private Pair<Integer, Integer> maxData(final String[] fileSystemInformation) {
        int maxX = 0;
        int maxY = 0;
        for (String nodeData : fileSystemInformation) {
            if (!nodeData.startsWith("/dev")) {
                continue;
            }
            Matcher xPosMatcher = _xPosPattern.matcher(nodeData);
            Matcher yPosMatcher = _yPosPattern.matcher(nodeData);
            Preconditions.checkArgument(xPosMatcher.find() && yPosMatcher.find(), "Illegal node!");

            maxX = Math.max(Integer.parseInt(xPosMatcher.group()), maxX);
            maxY = Math.max(Integer.parseInt(yPosMatcher.group()), maxY);
        }
        maxX++;
        maxY++;
        return new Pair<>(maxX, maxY);
    }


    private NodeInfo[][] from(final String[] nodeInput, final int maxX, final int maxY) {
        NodeInfo[][] nodeInfos = new NodeInfo[maxX][maxY];
        for (int i = 0; i < nodeInput.length; ++i) {
            if (!nodeInput[i].startsWith("/dev")) {
                continue;
            }
            String[] fileParts = nodeInput[i].split("\\s+");
            Matcher xPosMatcher = _xPosPattern.matcher(nodeInput[i]);
            Matcher yPosMatcher = _yPosPattern.matcher(nodeInput[i]);
            Preconditions.checkArgument(xPosMatcher.find() && yPosMatcher.find(), "Illegal node!");
            int x = Integer.parseInt(xPosMatcher.group());
            int y = Integer.parseInt(yPosMatcher.group());
            nodeInfos[x][y] = new NodeInfo(fileParts[0].trim(),
                    Integer.parseInt(fileParts[1].trim().replace("T", "")),
                    Integer.parseInt(fileParts[2].trim().replace("T", "")),
                    Integer.parseInt(fileParts[3].trim().replace("T", "")),
                    Integer.parseInt(fileParts[4].trim().replace("%", "")));
        }
        return nodeInfos;
    }


    private class NodeInfo {
        private final String _name;
        private final int _size;
        private final int _used;
        private final int _available;
        private final int _use;


        public NodeInfo(final String name, final int size, final int used, final int available,
                final int use) {
            _name = name;
            _size = size;
            _used = used;
            _available = available;
            _use = use;
        }
    }
}
