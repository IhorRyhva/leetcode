package LeetCode.secondMonth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DNAsequence {
    public static void main(String[] args) {
        findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").forEach(System.out::println);
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 9) return new ArrayList<>();
        HashMap<String, Integer> frequencyOfString = new HashMap<>();
        List<String> result = new ArrayList<>();
        char[] DNArray = s.toCharArray();
        int right = 9;

        for (int left = 0; right < DNArray.length; left++) {
            StringBuilder window = new StringBuilder();
            String windowStr = "";
            for (int i = left; i <= right; i++) {
                window.append(DNArray[i]);
                windowStr = window.toString();
            }
            frequencyOfString.merge(windowStr, 1, Integer::sum);
            right++;
        }
        for(String value: frequencyOfString.keySet()){
            if(frequencyOfString.get(value) > 1){
                result.add(value);
            }
        }
        return result;
    }
}

