package br.com.mhbp.geek_for_geeks.arrays;

public class ConvertToFive {
    public static void main(String[] args) {

//        System.out.println(1004%10);
        System.out.println(convertFive(1004));
        System.out.println(convertFive(121));
    }

    static int convertFive(int num) {

        int result = 0;
        int pow = 1;
        while (num > 0) {
            int d = num % 10;
            if (d == 0) {
                d = 5;
            }
            num /= 10;
            result = result + (d * pow);
            pow *= 10;
        }

        return result;
    }
}
