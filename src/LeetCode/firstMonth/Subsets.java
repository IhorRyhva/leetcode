package LeetCode.firstMonth;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        subsets.subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        createSubsets(0, nums, result, list);

        return result;
    }

    private void createSubsets(int index, int[] nums, List<List<Integer>> result, ArrayList<Integer> list) {
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        createSubsets(index+1, nums, result, list);

        list.remove(list.size() - 1);
        createSubsets(index+1, nums, result, list);
    }


}
