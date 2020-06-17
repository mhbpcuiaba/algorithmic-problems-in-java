package br.com.mhbp.greedy;

import java.util.List;

public class RefuelingSchedule {

    static class CityAndRemainingGas {
        int city;
        int remainingGallons;

        public CityAndRemainingGas(int city, int ramiangGallons) {
            this.city = city;
            this.remainingGallons = ramiangGallons;
        }
    }

    static int MPG = 20;// each 20 Miles needs 1 gallon

    static int findAmpleCity(List<Integer> gallons, List<Integer> distance) {

        CityAndRemainingGas min = new CityAndRemainingGas(0, 0);
        final int numCitis = gallons.size();
        int remaingGallons = 0;

        for (int i = 1; i < numCitis; i++) {
            int gallonsNeededToTrvelTheDistance = distance.get(i - 1) / MPG;
            remaingGallons += gallons.get(i - 1) - gallonsNeededToTrvelTheDistance;

            if (remaingGallons < min.remainingGallons) {
                min = new CityAndRemainingGas(i, remaingGallons);
            }

        }
        return min.city;
    }
}
