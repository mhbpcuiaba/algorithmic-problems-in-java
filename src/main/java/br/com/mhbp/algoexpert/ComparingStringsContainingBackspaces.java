package br.com.mhbp.algoexpert;


public class ComparingStringsContainingBackspaces {

    public static void main(String[] args) {
        System.out.println(compare("xy#z", "xzz#"));
        System.out.println(compare("xy#z", "xyz#"));
        System.out.println(compare("xp#", "xyz##"));
        System.out.println(compare("xywrrmp", "xywrrmu#p"));
    }

    private static boolean compare(String s1, String s2) {
        int s1Index = s1.length() - 1;
        int s2Index = s2.length() - 1;

        while (s1Index >= 0 || s2Index >= 0) {
            int i1 = getNextValidCharIndex(s1, s1Index);
            int i2 = getNextValidCharIndex(s2, s2Index);

            if (s1Index < 0 && s2Index < 0)
                return true;

            if (s1Index < 0 || s2Index < 0)
                return false;

            if (s1.charAt(s1Index--) != s2.charAt(s2Index--)) {
                return false;
            }
        }
        return true;
    }

    private static int getNextValidCharIndex(String s, int index) {
        int backspaceCounts = 0;

        while (index >= 0) {
            if (s.charAt(index) == '#') backspaceCounts++;
            else if (backspaceCounts > 0) backspaceCounts--;
            else break;
            index--;
        }

        return index;
    }
}
