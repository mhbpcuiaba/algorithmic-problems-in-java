package br.com.mhbp.bitsandbytes;

public class DetectIfTwoIntegersHaveOppositeSigns {
    private static String oppositeSigns(int x, int y) {
        return (x ^ y) < 0 ? "Signs are opposite" : "Signs are not opposite";
    }
}
