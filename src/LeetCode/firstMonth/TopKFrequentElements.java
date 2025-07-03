package LeetCode.firstMonth;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements elements = new TopKFrequentElements();
        int[] test = {1};
        int[] array = elements.topKFrequent(test, 1);
    }

    public int[] topKFrequent(int[] nums, int k) {
        int index = 0;
        int[] result = new int[k];
        HashMap<Integer, Integer> mapOfNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mapOfNums.merge(nums[i], 1, Integer::sum);
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for(Integer value: mapOfNums.values()){
            temp.add(value);
        }
        Collections.sort(temp, Comparator.reverseOrder());

        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if(i < temp.size())
                values.add(temp.get(i));
            else break;
        }
        for(Integer key: mapOfNums.keySet()){
            if(values.contains(mapOfNums.get(key))){
                if(index < k) {
                    result[index] = key;
                    index++;
                }else{
                    break;
                }
            }
        }
        return result;
    }


}
