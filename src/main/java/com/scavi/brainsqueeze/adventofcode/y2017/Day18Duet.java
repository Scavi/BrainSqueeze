package com.scavi.brainsqueeze.adventofcode.y2017;

import com.google.common.primitives.Ints;
import com.scavi.brainsqueeze.util.StringHelper;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Day18Duet {
    public long solveA(@Nonnull final String[] instructions) {
        Duet duet = new Duet(0, instructions);
        duet.run();
        return duet._lastSound;
    }

    public long solveB(@Nonnull final String[] instructions) throws InterruptedException {
        BlockingQueue<Long> queue1 = new LinkedBlockingQueue<>();
        BlockingQueue<Long> queue2 = new LinkedBlockingQueue<>();
        Duet duet0 = new Duet(0, instructions, queue1, queue2);
        Duet duet1 = new Duet(1, instructions, queue2, queue1);
        try {
            duet0.start();
            duet1.start();
            int count = 0;
            while (count < 5) {
                Thread.sleep(10);
                count = queue1.size() > 0 || queue2.size() > 0 ? 0 : count + 1;
            }
        } finally {
            duet0.interrupt();
            duet1.interrupt();
        }
        return duet1._sendCount;
    }

    private class Duet extends Thread {
        private final String[] _instructions;
        private final int _id;
        private BlockingQueue<Long> _sendQueue;
        private BlockingQueue<Long> _receiveQueue;
        private long _sendCount = 0;
        private long _lastSound = 0;
        private Map<Character, Long> _assembly;

        Duet(final int id, final String[] instructions) {
            this(id, instructions, null, null);
        }

        Duet(final int id,
             final String[] instructions,
             final BlockingQueue<Long> sendQueue,
             final BlockingQueue<Long> receiveQueue) {
            _id = id;
            _instructions = instructions;
            _sendQueue = sendQueue;
            _receiveQueue = receiveQueue;
        }

        @Override
        public void run() {
            _assembly = new HashMap<>();
            _assembly.put('p', (long) _id);
            try {
                for (int i = 0; i < _instructions.length && !isInterrupted(); ++i) {
                    String[] instructionTokens = StringHelper.split(_instructions[i], " ");
                    char key = instructionTokens[1].charAt(0);
                    switch (instructionTokens[0]) {
                        case "snd":
                            Integer tmpSnd = Ints.tryParse(String.valueOf(key));
                            _lastSound = tmpSnd == null ? get(key) : tmpSnd;
                            if (_sendQueue != null) {
                                _sendQueue.add(_lastSound);
                                _sendCount++;
                            }
                            break;
                        case "rcv":
                            if (get(key) != 0 || _receiveQueue != null) {
                                // if no receive queue is given, end the iteration with the first rcv
                                if (_receiveQueue == null) {
                                    return;
                                }
                                _assembly.put(key, _receiveQueue.take());
                            }
                            break;
                        default:
                            Integer tmp = Ints.tryParse(instructionTokens[2]);
                            long value = tmp != null ? tmp : _assembly.get(instructionTokens[2].charAt(0));
                            switch (instructionTokens[0]) {
                                case "set":
                                    _assembly.put(key, value);
                                    break;
                                case "add":
                                    _assembly.put(key, get(key) + value);
                                    break;
                                case "mul":
                                    _assembly.put(key, get(key) * value);
                                    break;
                                case "mod":
                                    _assembly.put(key, get(key) % value);
                                    break;
                                case "jgz":
                                    Integer tmpJump = Ints.tryParse(String.valueOf(key));
                                    if ((tmpJump != null && tmpJump > 0) || get(key) > 0) {
                                        i += (value - 1);
                                    }
                                    break;
                            }
                            break;
                    }
                }
            } catch (InterruptedException ex) {
                System.err.println("Deadlock identified");
            }
        }

        private long get(final char key) {
            return _assembly.getOrDefault(key, 0L);
        }
    }
}