package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class Third {
    public static void main(String[] args){
        Third third = new Third();
        System.out.println(third.lengthOfLongestSubstring("jbpnbwwd"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        ArrayList<Integer> counts = new ArrayList<>();
        char[] array = s.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            for(int j = i; j < array.length; j++){
                if(!characters.contains(array[j])){
                    characters.add(array[j]);
                }else{
                    counts.add(characters.size());
                    characters.clear();
                    break;
                }
            }
            counts.add(characters.size());
        }

        return Collections.max(counts);
    }
}
