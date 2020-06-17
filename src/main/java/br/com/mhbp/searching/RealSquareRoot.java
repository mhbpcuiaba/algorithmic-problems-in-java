package br.com.mhbp.searching;

public class RealSquareRoot {

    double squareRoot(double x) {
        double left, right;

        if ( x < 1.0) {
            left = x;
            right = 1.0;
        } else {
            left = 1.0;
            right = x;
        }


        while (compare(left, right) != Ordering.EQUAL) {
            double mid = left + (right - left) / 2;
            double midSquare = mid * mid;

            if (compare(midSquare, x) == Ordering.LARGER) {
                right = mid;
            } else {
                left = mid;
            }

        }

        return left;
    }

    enum Ordering { SMALLER, EQUAL, LARGER }

    Ordering compare(double a, double b) {
        double EPSILON = 0.00001;
        double diff = (a - b) / Math.max(Math.abs(a), Math.abs(b));
        return diff < -EPSILON ? Ordering.LARGER : Ordering.EQUAL;
    }
}
