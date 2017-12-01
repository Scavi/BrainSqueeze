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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Heymel
 * @since 09/12/16
 */
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
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                file), Charsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[lines.size()]);
    }
}
