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

package com.scavi.brainsqueeze.util;

import com.google.common.base.Charsets;
import com.scavi.brainsqueeze.adventofcode.y2016.Day8TwoFactorAuthentication;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Michael Heymel
 * @since 09/12/16
 */
@ParametersAreNonnullByDefault
public class FileHelper {

    public static File forUnitTests(final String inputDir) {
        URL uri = Day8TwoFactorAuthentication.class.getClassLoader().getResource("");
        return new File(uri.getPath() + "../../../src/input/" + inputDir);
    }


    /**
     * Reads the given file and return the lines as array while each line is represented by the
     * corresponding array position
     *
     * @param file the file to read
     * @return the array with the lines of the file
     */
    public static String[] readLines(final File file) throws IOException {
        List<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                file), Charsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[lines.size()]);
    }


    /**
     * Parses a given file and tokenizes each line by the delimiter to determine the integer values.
     *
     * @param file the file
     * @return the matrix or <code>null</code>
     * @throws IOException
     */
    public static int[][] toIntMatrix(final File file) throws IOException {
        String[] lines = readLines(file);
        int[][] matrix = null;

        if (lines.length > 0) {
            matrix = new int[lines.length][];
            int row = 0;
            for (String line : lines) {
                List<Integer> lineIntegers = new LinkedList<>();
                Matcher numberMatcher = Pattern.compile("\\d+").matcher(line);
                while (numberMatcher.find()) {
                    int value = Integer.parseInt(numberMatcher.group());
                    lineIntegers.add(value);
                }
                matrix[row++] = PrimitiveHelper.toPrimitive(lineIntegers);
            }
        }
        return matrix;
    }
}
