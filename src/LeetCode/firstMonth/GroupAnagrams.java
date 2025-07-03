package LeetCode.firstMonth;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] test = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = anagrams.groupAnagrams(test);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(strs[0]);
        groups.put(getKey(strs[0]), list1);

        for (int i = 1; i < strs.length; i++) {
            String key = getKey(strs[i]);
            if(groups.containsKey(key)){
                groups.get(key).add(strs[i]);
            }else{
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(strs[i]);
                groups.put(key, arrayList);
            }
        }

        return toResult(groups);
    }

    private String getKey(String strs) {
        char[] array = strs.toCharArray();
        Arrays.sort(array);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
        }
        return builder.toString();
    }


    private List<List<String>> toResult(HashMap<String, List<String>> map){
        List<List<String>> result = new ArrayList<>();
        for(List<String> list: map.values()){
            result.add(list);
        }
        return result;
    }

}
