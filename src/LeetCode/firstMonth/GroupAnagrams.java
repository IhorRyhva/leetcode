package LeetCode.firstMonth;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] test = {"", "b", ""};
        List<List<String>> result = anagrams.groupAnagrams(test);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        String forGroup = null;
        List<String> list = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            if(forGroup == null && strs[i] != null){
                forGroup = strs[i];
                strs[i] = null;
                list.add(forGroup);
                count = 0;
            }else if(strs[i] == null){
                count++;
            }else if(matchForGroup(forGroup, strs[i])){
                count = 0;
                list.add(strs[i]);
                strs[i] = null;
            }

            if(i == strs.length - 1){
                forGroup = null;
                if(count != strs.length) i = -1;
                if(!list.isEmpty())
                    result.add(list);
                list = new ArrayList<>();
                count = 0;
            }
        }
        return result;
    }

    private boolean matchForGroup(String s1, String s2){
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        if(s1.length() != s2.length()){
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            boolean match = false;
            for (int j = 0; j < array2.length; j++) {
                if(array1[i] == array2[j]){
                    array2[j] = ' ';
                    match = true;
                    break;
                }
            }
            if(!match){
                return false;
            }
        }
        return true;
    }
}
