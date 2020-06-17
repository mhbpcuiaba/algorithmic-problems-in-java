package br.com.mhbp.arrays_primitives_strings.strings;

import java.util.ArrayList;
import java.util.List;

public class ValidIpAddresses {



    public List<String> generateAllIPAddresses(String str) {
        ArrayList<String> result = new ArrayList<>();


        //ip section has 3 digits, so  i <= 3 with initial value i's is 1
        for (int i = 1; i <= 3 && i < str.length(); i++) {
            String first = str.substring(0, i);

            if (isValidPart(first)) {

                for (int j = 1; j + i < str.length() && j <= 3 ; j++) {
                    String second = str.substring(i, i + j);

                    if (isValidPart(second)) {

                        for (int k = 2; k + j + i < str.length() && k <= 3; k++) {
                            String third = str.substring(i + j, i + j + k);
                            String fourth = str.substring(i + j + k);

                            if (isValidPart(third) && isValidPart(fourth)) {
                                result.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isValidPart(String ip) {

        if ( ip.length() > 3) return false;

        //00, 000, 01, etc. are not valid, but 0 is valid
        if (ip.startsWith("0") && ip.length() > 1) return false;

        int ipInt = Integer.parseInt(ip);
        return ipInt <= 255 && ipInt >= 0;
    }
}
