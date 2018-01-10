package com.scavi.brainsqueeze.misc;

import javax.annotation.Nonnull;
import java.util.regex.Pattern;

public class PatternDigitMatcher {

    /**
     * Give you a pattern (digit in the pattern matches the corresponding
     * number of letters,
     * letter means match the letter itself),
     * a string to determine whether match:
     * ex:
     * abc -> 'abc' true
     * '1oc3' -> 'aoczzz', 'bocabc' true
     *
     * @param matcher the match pattern
     * @param text    the text to match
     * @return <code>true</code> is a match, <code>false</code> else
     */
    public boolean isMatch(@Nonnull final String matcher, @Nonnull final String text) {
        StringBuilder matchPattern = new StringBuilder();
        for (char c : matcher.toCharArray()) {
            if (c >= 48 && c <= 57) {
                matchPattern.append("[a-z]{").append(c).append("}");
            } else {
                matchPattern.append(c);
            }
        }
        Pattern pattern = Pattern.compile(matchPattern.toString(), Pattern.CASE_INSENSITIVE);
        return pattern.matcher(text).matches();
    }
}
