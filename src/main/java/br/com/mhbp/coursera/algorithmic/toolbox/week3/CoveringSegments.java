package br.com.mhbp.coursera.algorithmic.toolbox.week3;

import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {

        Arrays.sort(segments, Comparator.comparingInt(s -> s.end));
        List<Integer> points = new ArrayList<>();
        int p = -1;
        for (int i = 0; i < segments.length; i++) {
            if (!(segments[i].start <= p && segments[i].end >= p)) {
                points.add(segments[i].end);
                p = segments[i].end;
            }
        }
        return points.stream().mapToInt( i -> i).toArray();
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

