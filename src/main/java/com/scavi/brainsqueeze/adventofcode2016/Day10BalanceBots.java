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

package com.scavi.brainsqueeze.adventofcode2016;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Solves both questions http://adventofcode.com/2016/day/10
 *
 * @author Michael Heymel
 * @since 11/12/16
 */
public class Day10BalanceBots {
    private static final Pattern BOT_SOURCE_PATTERN = Pattern.compile("(?<=(bot\\s))[^\\s]*");
    private static final Pattern BOT_LOW_REFERENCE_TO_BOT =
            Pattern.compile("(?<=(gives\\slow\\sto\\sbot\\s))[^\\s]*");
    private static final Pattern BOT_HIGH_REFERENCE_TO_BOT =
            Pattern.compile("(?<=(and\\shigh\\sto\\sbot\\s))[^$]*");
    private static final Pattern BOT_LOW_REFERENCE_TO_OUTPUT =
            Pattern.compile("(?<=(gives\\slow\\sto\\soutput\\s))[^\\s]*");
    private static final Pattern BOT_HIGH_REFERENCE_TO_OUTPUT =
            Pattern.compile("(?<=(and\\shigh\\sto\\soutput\\s))[^$]*");

    private static final Pattern VALUE_INPUT_PATTERN = Pattern.compile("(?<=(value\\s))[^\\s]*");
    private static final Pattern VALUE_TARGET_BOT_PATTERN = Pattern.compile("(?<=(bot\\s))[^$]*");

    private Queue<Bot> _readyBots = new LinkedList<>();
    private Map<Integer, List<Integer>> _output = new HashMap<>();


    /**
     * This method setups the bots and processes them according to the given instructions. The
     * method looks up the bot that processes the given lookup1 and lookup2.
     * <p/>
     * To solve both questions, this method processes all robots, even if the bot was
     * found
     *
     * @param instructions the processing instructions for the army of bots
     * @param lookup1      the lookup value 1
     * @param lookup2      the lookup value 2
     * @return the bot that processes lookup value 1 and 2
     */
    public Bot lookupProcessingBot(final String[] instructions, final int lookup1,
            final int lookup2) {
        Preconditions.checkNotNull(instructions, "Illegal instruction input: <null>");
        _readyBots = new LinkedList<>();

        Map<Integer, Bot> botArmy = new HashMap<>();
        Bot processingBot = null;
        for (String instruction : instructions) {
            Bot tmp = processInstruction(botArmy, instruction, lookup1, lookup2, false);
            if (processingBot == null) {
                processingBot = tmp;
            }
        }
        return processingBot;
    }


    /**
     * @param instructions the processing instructions for the army of bots
     * @param lookup1      the lookup value 1
     * @param lookup2      the lookup value 2
     * @param outputIds    all output IDs to multiply their content
     * @return the multiplied content
     */
    public long outputValues(final String[] instructions, final int lookup1, final int lookup2,
            int... outputIds) {
        Preconditions.checkNotNull(outputIds, "Illegal output lookup: <null>");
        Preconditions.checkArgument(outputIds.length > 0, "Illegal output lookup: 0");
        _output = new HashMap<>();

        lookupProcessingBot(instructions, lookup1, lookup2);

        long result = 1;
        for (int lookup : outputIds) {
            Preconditions.checkArgument(_output.containsKey(lookup),
                    "Illegal output container: " + lookup);
            for (int inOutput : _output.get(lookup)) {
                result *= inOutput;
            }
        }
        return result;
    }


    /**
     * Processes the given instruction to find the bot who processes lookup value 1 and 2
     *
     * @param botArmy        all available bots
     * @param instruction    the processing instructions for the army of bots
     * @param lookup1        the lookup value 1
     * @param lookup2        the lookup value 2
     * @param isBotExecution <code>true</code> currently a bot uses the method to process it's
     *                       instruction<code>false</code> otherwise the general given instruction
     * @return the bot who processes lookup value 1 and 2 or <code>null</code>
     */
    private Bot processInstruction(final Map<Integer, Bot> botArmy, final String instruction,
            final int lookup1, final int lookup2, final boolean isBotExecution) {
        Bot lookupBot = null;


        if (instruction.contains("output")) {
            System.out.println();
        }

        // do something with a bot
        if (instruction.startsWith("bot")) {
            Matcher botSourceMatcher = BOT_SOURCE_PATTERN.matcher(instruction);
            Preconditions.checkArgument(botSourceMatcher.find(),
                    "Illegal bot source reference instruction: " + instruction);

            int sourceBotId = Integer.parseInt(botSourceMatcher.group());
            // bot is known
            if (botArmy.containsKey(sourceBotId)) {
                Bot sourceBot = botArmy.get(sourceBotId);
                // and can process something (has two values)
                if (sourceBot.isProcessable()) {
                    Matcher lowToBot = BOT_LOW_REFERENCE_TO_BOT.matcher(instruction);
                    Matcher highToBot = BOT_HIGH_REFERENCE_TO_BOT.matcher(instruction);
                    Matcher lowToOutput = BOT_LOW_REFERENCE_TO_OUTPUT.matcher(instruction);
                    Matcher highToOutput = BOT_HIGH_REFERENCE_TO_OUTPUT.matcher(instruction);

                    // process low (from bot to bot)
                    if (lowToBot.find()) {
                        int lowBotReference = Integer.parseInt(lowToBot.group());
                        processFromBotToBot(botArmy, sourceBot.getLow(), lowBotReference);
                        // queue the bot for further processable
                        addReadyBot(botArmy.get(lowBotReference));
                    }
                    // process low (from bot to output)
                    else if (lowToOutput.find()) {
                        putOutput(Integer.parseInt(lowToOutput.group()), sourceBot.getLow());
                    } else {
                        throw new IllegalArgumentException(
                                "Illegal low instruction: " + instruction);
                    }
                    // process high (from bot to bot)
                    if (highToBot.find()) {
                        int highBotReference = Integer.parseInt(highToBot.group());
                        processFromBotToBot(botArmy, sourceBot.getHigh(), highBotReference);
                        // queue the bot for further processable
                        addReadyBot(botArmy.get(highBotReference));
                    }
                    // gives the package to an output bin
                    else if (highToOutput.find()) {
                        putOutput(Integer.parseInt(highToOutput.group()), sourceBot.getHigh());
                    } else {
                        throw new IllegalArgumentException(
                                "Illegal high instruction: " + instruction);
                    }
                }
                // bot is known but not processable yet
                else {
                    // only add new instructions if the bot is currently not in the processing phase
                    if (!isBotExecution) {
                        botArmy.get(sourceBotId).instructions().add(instruction);
                    }
                }
            }
            // new bot - store the instruction
            else {
                Bot bot = new Bot(sourceBotId);
                bot.instructions().add(instruction);
                botArmy.put(sourceBotId, bot);
            }
        }
        // insert a new value from an input
        else if (instruction.startsWith("value")) {
            Matcher valueMatcher = VALUE_INPUT_PATTERN.matcher(instruction);
            Matcher targetBot = VALUE_TARGET_BOT_PATTERN.matcher(instruction);
            Preconditions.checkArgument(valueMatcher.find() && targetBot.find(),
                    "Illegal value instruction: " + instruction);

            Integer value = Integer.parseInt(valueMatcher.group());
            int targetBotId = Integer.parseInt(targetBot.group());
            // existing bot, place an additional value to the bot
            if (botArmy.containsKey(targetBotId)) {
                Bot existingBot = botArmy.get(targetBotId);
                existingBot.placePackage(value);

                if (existingBot.isProcessing(lookup1, lookup2)) {
                    lookupBot = existingBot;
                } else if (existingBot.isProcessable()) {
                    addReadyBot(existingBot);
                }
            }
            // new bot, store the determined value
            else {
                Bot bot = new Bot(targetBotId);
                bot.placePackage(value);
                botArmy.put(targetBotId, bot);
            }
        } else {
            throw new IllegalArgumentException("Unknown instruction: " + instruction);
        }

        // only if it is not currently processing a bot.
        if (!isBotExecution) {
            while (_readyBots.peek() != null) {
                Bot tmp = processBotInstructions(botArmy, _readyBots.poll(), lookup1, lookup2);
                if (lookupBot == null) {
                    lookupBot = tmp;
                }
            }
        }

        return lookupBot;
    }


    /**
     * Puts the given value into the container with the output id
     *
     * @param outputId the id of the output container
     * @param value    the value to put
     */
    private void putOutput(final int outputId, final Integer value) {
        if (!_output.containsKey(outputId)) {
            _output.put(outputId, new LinkedList<Integer>());
        }
        _output.get(outputId).add(value);
    }


    /**
     * Add's a bot to the ready bot's if both values are set
     *
     * @param bot the bot to add
     */
    private void addReadyBot(final Bot bot) {
        if (bot.isProcessable() && !_readyBots.contains(bot)) {
            _readyBots.add(bot);
        }
    }


    /**
     * Initiates the processing of the bot instructions
     *
     * @param botArmy    all available bots
     * @param currentBot the bot to process it's extractions
     * @param lookup1    the lookup value 1
     * @param lookup2    the lookup value 2
     * @return the bot who processes lookup value 1 and 2 or <code>null</code>
     */
    private Bot processBotInstructions(final Map<Integer, Bot> botArmy, final Bot currentBot,
            final int lookup1, final int lookup2) {
        Bot lookupBot = currentBot.isProcessing(lookup1, lookup2) ? currentBot : null;


        while (currentBot.instructions().peek() != null) {
            Bot tmp = processInstruction(botArmy,
                    currentBot.instructions().poll(),
                    lookup1,
                    lookup2,
                    true);
            if (lookupBot == null) {
                lookupBot = tmp;
            }
        }
        return lookupBot;
    }


    /**
     * This is a helper method to process a value to a target reference. In case, the bot isn't
     * known yet, it will be added
     *
     * @param botArmy   all known bots
     * @param value     the value to process
     * @param reference the target reference to the bot
     */
    private void processFromBotToBot(final Map<Integer, Bot> botArmy, final Integer value,
            final int reference) {
        Bot targetBot;
        if (botArmy.containsKey(reference)) {
            targetBot = botArmy.get(reference);
        } else {
            targetBot = new Bot(reference);
        }
        targetBot.placePackage(value);
        botArmy.put(reference, targetBot);
    }


    static class Bot {
        private Queue<String> _cachedInstructions = new LinkedList<>();
        private final int _botId;
        private Integer _value1;
        private Integer _value2;


        /**
         * Constructor
         *
         * @param botId the unique bot id
         */
        Bot(final int botId) {
            _botId = botId;
        }


        /**
         * @return the queue with stored instructions for the bot
         */
        Queue<String> instructions() {
            return _cachedInstructions;
        }


        @Override
        public int hashCode() {
            return _botId;
        }


        @Override
        public boolean equals(final Object obj) {
            if (obj == null || obj.getClass() != Bot.class) {
                return false;
            }
            return _botId == ((Bot) obj).getBotId();
        }


        /**
         * Places a package into the bot. The method will select the first free place
         *
         * @param value the value to set
         */
        public void placePackage(final Integer value) {
            Preconditions.checkArgument(_value1 == null || _value2 == null,
                    "Bot can't take anything more!");
            if (_value1 == null) {
                _value1 = value;
            } else {
                _value2 = value;
            }
        }


        /**
         * @return A bot only starts to move if both values are set
         */
        boolean isProcessable() {
            return _value1 != null && _value2 != null;
        }


        /**
         * Validates if the current bot is the bot who is processing both lookup values
         *
         * @param lookup1 the lookup value 1
         * @param lookup2 the lookup value 2
         * @return <code>true</code> bot found, <code>false</code> else
         */
        boolean isProcessing(final int lookup1, final int lookup2) {
            return isProcessable() && ((_value1 == lookup1 && _value2 == lookup2) ||
                    (_value2 == lookup1 && _value1 == lookup2));
        }


        /**
         * @return the low result of the bot. Also the returned value within the bot will be set to
         * <code>null</code>
         */
        Integer getLow() {
            Integer tmp;
            if (_value1 != null && _value2 != null) {
                if (_value1 > _value2) {
                    tmp = _value2;
                    _value2 = null;
                } else {
                    tmp = _value1;
                    _value1 = null;
                }
            } else if (_value1 != null) {
                tmp = _value1;
                _value1 = null;
            } else {
                tmp = _value2;
                _value2 = null;
            }
            return tmp;
        }


        /**
         * @return the high result of the bot. Also the returned value within the bot will be set to
         * <code>null</code>
         */
        public Integer getHigh() {
            Integer tmp;
            if (_value1 != null && _value2 != null) {
                if (_value1 > _value2) {
                    tmp = _value1;
                    _value1 = null;
                } else {
                    tmp = _value2;
                    _value2 = null;
                }
            } else if (_value1 != null) {
                tmp = _value1;
                _value1 = null;
            } else {
                tmp = _value2;
                _value2 = null;
            }
            return tmp;
        }


        /**
         * @return the unique id of the bot
         */
        int getBotId() {
            return _botId;
        }


        @Override
        public String toString() {
            return String.format("ID=%s with (%s , %s) [Instructions: %s]",
                    _botId,
                    _value1,
                    _value2,
                    _cachedInstructions.size());
        }
    }
}