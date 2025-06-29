package LeetCode.tryLeetCode;

import java.util.*;

public class SumThree {

    public static void main(String[] args) {
        SumThree sum = new SumThree();
        int[] nums = {0,0,0};
        sum.threeSum(nums).stream().forEach(o -> o.forEach(System.out::println));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (right > left){
                if(nums[i] + nums[left] + nums[right] == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right-1]) {
                        right--;
                    }

                    left++;
                    right--;
                }else if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
}
