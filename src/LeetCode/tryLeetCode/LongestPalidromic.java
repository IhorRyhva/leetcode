package LeetCode.tryLeetCode;

import java.util.*;

public class LongestPalidromic {
    public static void main(String[] args) {

        LongestPalidromic fiveth = new LongestPalidromic();
        System.out.println(fiveth.longestPalindrome("bacabab"));
    }

    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        ArrayList<String> result = new ArrayList<>();

        Map<Character, List<Integer>> indexOfChars = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(indexOfChars.containsKey(array[i])){
                indexOfChars.get(array[i]).add(i);
            }else{
                ArrayList list = new ArrayList<>();
                list.add(i);
                indexOfChars.put(array[i], list);
            }
        }

        for(Character character: indexOfChars.keySet()){
            List<Integer> list = indexOfChars.get(character);
            int firstIndex = list.get(0);
            int lastIndex = list.get(list.size() - 1);

            String test = s.substring(firstIndex, lastIndex + 1);
            StringBuilder builder = new StringBuilder(test);
            builder.reverse();

            if(test.equals(builder.toString())){
                result.add(test);
            }else if(list.size() > 1) {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i; j < list.size(); j++) {
                        if (i != j) {
                            String temp = s.substring(list.get(i), list.get(j) + 1);
                            StringBuilder reversed = new StringBuilder(temp);
                            reversed.reverse();
                            if (temp.equals(reversed.toString())) {
                                result.add(temp);
                            }
                        }
                    }
                }
            }else{
                result.add(character.toString());
            }
        }

        return BigestPolidrom(result);
    }

    private String BigestPolidrom(ArrayList<String> list){
        return Collections.max(list, new CompareByLenght());
    }

    private class CompareByLenght implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }
}
