package br.com.mhbp.backtracking;

import java.util.ArrayList;
import java.util.List;

public class IPAddressDecompositionProblem {


    public static final int SEGMENTS = 4;

    public static List<String> restoreAllIpAddresses(String ipWithouDots) {
        ArrayList<String> allPossiblesIPs = new ArrayList<>();
        int[] path = new int[SEGMENTS];


        generateAllPosiblesIPs(allPossiblesIPs, ipWithouDots, 0, path, 0);
        return allPossiblesIPs;
    }

    private static void generateAllPosiblesIPs(ArrayList<String> allPossiblesIPs, String ipWithouDots, int builderIndex, int[] ipsSegment, int segment) {

        if (segment == SEGMENTS && builderIndex == ipWithouDots.length()) {
            allPossiblesIPs.add(ipsSegment[0] + "." + ipsSegment[1] + "." + ipsSegment[2] + "." + ipsSegment[3]);
            return;
        } else if (segment == SEGMENTS || builderIndex == ipWithouDots.length()) {
            //just ignore this branch, it is already wrong
            return;
        } else {

            for (int ipLength = 1; ipLength <= 3 && builderIndex + ipLength <= ipWithouDots.length(); ipLength++ ) {

                String ipSegementString = ipWithouDots.substring(builderIndex, builderIndex + ipLength);
                int currentIPSegement = Integer.parseInt(ipSegementString);

                if (currentIPSegement > 255 || ipLength >= 2 && ipWithouDots.charAt(builderIndex) == '0') {
                    break; //just ignore this branch, it is already wrong
                }

                ipsSegment[segment] = currentIPSegement;
                generateAllPosiblesIPs(allPossiblesIPs, ipWithouDots, builderIndex + ipLength, ipsSegment, segment + 1);
                ipsSegment[segment] = -1;
            }
        }
    }
}
