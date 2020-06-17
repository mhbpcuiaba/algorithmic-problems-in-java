package br.com.mhbp.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskPairing {

    static class PairTask {
        int t1, t2;

        public PairTask(int t1, int t2) {
            this.t1 = t1;
            this.t2 = t2;
        }


    }

    static List<PairTask> optimumTaskAssignment(List<Integer> taskDurations) {
        Collections.sort(taskDurations);
        List<PairTask> optimumAssignment = new ArrayList<>();

        for (int i = 0, j = taskDurations.size() - 1; i < j ; i++, j++) {
            optimumAssignment.add(new PairTask(taskDurations.get(i), taskDurations.get(j)));
        }
        return optimumAssignment;
    }

    static int minimumTotalWaitingTime(List<Integer> serviceTimes) {
        int minWaitTime = 0;
        Collections.sort(serviceTimes);

        for (int i = 0; i < serviceTimes.size(); i++) {
            int numRemainingQueries = serviceTimes.size() - ( i + 1);
            minWaitTime += serviceTimes.get(i) * numRemainingQueries ;
        }
        return minWaitTime;
    }
}
