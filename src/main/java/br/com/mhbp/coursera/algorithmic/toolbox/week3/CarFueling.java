package br.com.mhbp.coursera.algorithmic.toolbox.week3;

import java.util.Scanner;

public class CarFueling {

    static int computeMinRefills(int dist, int tank, int[] stops) {
        int stopsTaken = 0;
        int fuel = tank;
        int stopIndex = 0;
        int travelledDistance = 0;

        while (stopIndex < stops.length && travelledDistance < dist  && fuel >= stops[stopIndex] - travelledDistance) { //it is reachable


            fuel = fuel - (stops[stopIndex] - travelledDistance);
            travelledDistance = stops[stopIndex];
            if ( (stopIndex + 1 < stops.length  && fuel < (stops[stopIndex + 1] - travelledDistance)) || ( stopIndex +1 == stops.length && (travelledDistance + fuel) < dist )) {
                fuel = tank;
                stopsTaken++;
            }
            stopIndex++;
        }

        if (tank <= 0 || travelledDistance + fuel < dist) return -1;

        return stopsTaken;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];

        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
