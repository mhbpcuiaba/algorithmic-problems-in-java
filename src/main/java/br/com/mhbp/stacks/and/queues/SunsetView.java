package br.com.mhbp.stacks.and.queues;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SunsetView {

    static class BuildingWithHeight {
        Integer id;
        Integer height;

        public BuildingWithHeight(Integer id, Integer height) {
            this.id = id;
            this.height = height;
        }
    }

    static List<Integer> examineBuildingsWithSunset(Iterator<Integer> sequence) {
        int buildingIdx = 0;
        ArrayDeque<BuildingWithHeight> candidates = new ArrayDeque<>();

        while ((sequence.hasNext())) {
            Integer buildingHeight = sequence.next();

            while (!candidates.isEmpty() && buildingHeight >= candidates.peekFirst().height)  { //remove smallers than the newOne
                candidates.removeFirst();
            }

            candidates.addFirst(new BuildingWithHeight(buildingIdx++, buildingHeight));
        }

        // candidates.add == candidates.addLast
        // candidates.remove == candidates.removeLast
        return candidates.stream().map( c -> c.id).collect(Collectors.toList());
    }
}
