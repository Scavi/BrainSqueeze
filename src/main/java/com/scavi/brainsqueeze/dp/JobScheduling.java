package com.scavi.brainsqueeze.dp;

import com.scavi.brainsqueeze.util.Pair;

import javax.annotation.Nonnull;
import java.util.*;

public class JobScheduling {

    /**
     * Given an array of jobs with a start and end int value (end is excluding), find the max amount someone can get
     * from taking the jobs.
     * Taken jobs must be non overlapping.
     *
     * @param jobs all jobs
     * @return the max amount + the list which jobs must be taken
     */
    public Pair<Integer, List<Integer>> findMaxLucrativeJobs(@Nonnull final Job... jobs) {
        if (jobs.length == 0) {
            return new Pair<>(0, new ArrayList<>());
        }
        Arrays.sort(jobs, Comparator.comparingInt(v -> v._to));
        int[] jobProfit = new int[jobs.length];
        List<List<Integer>> takenJobs = new ArrayList<>(jobs.length);
        int maxPos = 0;
        for (int i = 0; i < jobs.length; ++i) {
            jobProfit[i] = jobs[i].getPrice();
            maxPos = jobProfit[i] > jobProfit[maxPos] ? i : maxPos;
            List<Integer> positions = new LinkedList<>();
            positions.add(i);
            takenJobs.add(i, positions);
        }

        for (int i = 1; i < jobs.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (jobs[j].getTo() > jobs[i].getFrom()) {
                    break;
                }
                if (jobProfit[i] < jobProfit[j] + jobs[i].getPrice()) {
                    jobProfit[i] = jobProfit[j] + jobs[i].getPrice();
                    takenJobs.set(i, clone(takenJobs.get(j)));
                    takenJobs.get(i).add(i);
                    maxPos = jobProfit[i] > jobProfit[maxPos] ? i : maxPos;
                }
            }
        }
        return new Pair<>(jobProfit[maxPos], takenJobs.get(maxPos));
    }

    private List<Integer> clone(final List<Integer> toClone) {
        List<Integer> result = new LinkedList<>();
        result.addAll(toClone);
        return result;
    }


    public static class Job {
        private final int _price;
        private final int _from;
        private final int _to;

        public Job(int price, int from, int to) {
            _price = price;
            _from = from;
            _to = to;
        }

        public int getPrice() {
            return _price;
        }

        public int getFrom() {
            return _from;
        }

        public int getTo() {
            return _to;
        }
    }
}
