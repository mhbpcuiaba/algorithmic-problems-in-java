package br.com.mhbp.codility._1_iterations;

public class BinaryGap {

    public static void main(String[] args) {

//        String binaryRepresentationStr = binaryRepresentation(1);

        System.out.println(binaryGap(9));
        System.out.println(binaryGap(32));
        System.out.println(binaryGap(1041));
        System.out.println("GAME OVER");
    }

    public static int binaryGap(int number) {
        int maxBinaryGap = 0;
        String s = binaryRepresentation(number);

        int index = 0, begin = 0 , end = 0;

        while (index < s.length()) {

            int count = 0;
            while (index < s.length() && s.charAt(index) == '0' ) {
                count++;
                index++;
            }

            if (maxBinaryGap < count && index < s.length()) {
                maxBinaryGap = count;
            }
            index++;
        }

        return maxBinaryGap;
    }
    static String binaryRepresentation(int number) {
        String binaryResult = "";
        if ( number < 0) return binaryResult;
        if (number < 2) return binaryResult + number;

        while( number > 0) {
            binaryResult = number % 2 + binaryResult;
            number /= 2;
        }

        return binaryResult;

    }
}
