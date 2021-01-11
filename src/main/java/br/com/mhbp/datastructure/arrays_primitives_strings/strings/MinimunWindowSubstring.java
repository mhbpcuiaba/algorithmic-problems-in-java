package br.com.mhbp.datastructure.arrays_primitives_strings.strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/*
S= search string length
t: pattern string length

Time: O(s + t)
Space: O(s + t)
 */
public class MinimunWindowSubstring {

    public static void main(String[] args) {
        String searchString = "adobecodebanc";
        String pattern = "abc";

        System.out.println("starting");
        System.out.println(bruteForceApproach(searchString, pattern));
        System.out.println(linearApproach(searchString, pattern));
        System.out.println("finish");
    }

    public static String bruteForceApproach(String content, String pattern) {


        String minimum = "";
        int minimumCount = Integer.MAX_VALUE;
        content.toCharArray();
        char[] charsPattern = pattern.toCharArray();

        List<Character> chars = content.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> patternList = pattern.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        outer_loop:
        for (int i = 0; i < chars.size(); i++) {

                if (patternList.contains(chars.get(i))) {
                    int index = patternList.indexOf(chars.get(i));
                    boolean[] used = new boolean[charsPattern.length];
                    used[index] = true;
                    int foundThem = 1;

                    for (int j = i + 1; j < chars.size(); j++) {

                        Character currentCaracter = chars.get(j);
                        int indexOf = patternList.indexOf(currentCaracter);

                        if (indexOf > -1 && used[indexOf] == false) {
                            used[indexOf] = true;
                            foundThem++;
                        }

                        //we found all of them and it is minimum window substring up to now
                        if (foundThem == used.length && minimumCount > (j - i)) {
                            minimumCount = (j - i);
                            minimum = content.substring(i, j+1);
                        }
                    }
                }
        }

        return minimum;
    }

    public static String linearApproach(String content, String pattern) {
        HashMap<Character, Integer> windowCharacterMapping = new HashMap<>(); ///counts the frequency of every character in the string being analyzed
        HashMap<Character, Integer> requiredCharacters = buildMappingOfCharacteres(pattern);

        int totalDifferentsCharToMatch = requiredCharacters.size();
        int charFrequenciesInWindowThatMatch = 0;

        int left = 0;
        int right = 0;

        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
        String minWindow = "";


        while (right < content.length()) {
            char characterAtRightPointer = content.charAt(right);
            addCharacterToMap(windowCharacterMapping, characterAtRightPointer);

            if ( requiredCharacters.containsKey(characterAtRightPointer) ) {
                int characterRequiredTimes = requiredCharacters.get(characterAtRightPointer).intValue();
                int currentTimesWeFoundThisCharacter = windowCharacterMapping.get(characterAtRightPointer).intValue(); // get the number of repetitions of characterAtRightPointer counted up to now

                //in this case characterAtRightPointer has appeared all the times that we expected, so we consider that for this specific character we havel matched all ocurrencies
                if (characterRequiredTimes == currentTimesWeFoundThisCharacter) {
                    charFrequenciesInWindowThatMatch++;
                }
            }

            //we get into the while when we find all the characters pattern inside string being analyzed
            while (charFrequenciesInWindowThatMatch == totalDifferentsCharToMatch && left <= right) {

                char characterAtLeftPointer = content.charAt(left);
                int windowSize = right - left + 1;

                //we found a better solution!!!!
                if (windowSize < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = windowSize;
                    minWindow = content.substring(left, right + 1);
                }

                windowCharacterMapping.put(characterAtLeftPointer,windowCharacterMapping.get(characterAtLeftPointer) - 1);

                boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
                if (leftCharIsARequirement) {
                    boolean characterFailsRequirement = windowCharacterMapping.get(characterAtLeftPointer).intValue() < requiredCharacters.get(characterAtLeftPointer).intValue();

                    if (characterFailsRequirement) {
                        charFrequenciesInWindowThatMatch--;
                    }
                }

                left++;
            }

            right++;
        }

        return minWindow;
    }

    private static HashMap<Character, Integer> buildMappingOfCharacteres(String pattern) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            Integer occurrencesOfCharacter = map.getOrDefault(pattern.charAt(i), 0);
            map.put(pattern.charAt(i), occurrencesOfCharacter + 1);
        }

        return map;
    }

    private static void addCharacterToMap(Map<Character, Integer> map, Character c) {
        Integer qtd = map.getOrDefault(c, 0);
        map.put(c, qtd + 1);
    }
}
