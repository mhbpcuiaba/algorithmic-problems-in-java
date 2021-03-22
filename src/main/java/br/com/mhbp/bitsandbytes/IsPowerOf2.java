package br.com.mhbp.bitsandbytes;

public class IsPowerOf2 {

    boolean isPowerOf2(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }
}

/*
  0010
  0110

  0101
   111

   101
 */