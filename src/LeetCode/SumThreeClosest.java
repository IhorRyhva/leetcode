package LeetCode;

import java.util.Arrays;

public class SumThreeClosest {

    public static void main(String[] args) {
        SumThreeClosest closest = new SumThreeClosest();
        int[] array = {0,0,0};
        System.out.println(closest.threeSumClosest(array, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int leftFlag = i + 1;
            int rightFlag = nums.length - 1;

            while (rightFlag > leftFlag){
                int sum = nums[rightFlag] + nums[leftFlag] + nums[i];
                if(sum > target){
                    rightFlag--;
                    result = closest(result, sum, target);
                }else if(sum < target){
                    leftFlag++;
                    result = closest(result, sum, target);
                }else{
                    return sum;
                }
            }
        }

        return result;
    }

    private int closest(int result, int mayResult, int target){
        int ifMayResult = target - mayResult;
        if(ifMayResult < 0) ifMayResult *= -1;

        int ifResult = target - result;
        if(ifResult < 0) ifResult *= -1;

        if(ifResult < ifMayResult){
            return result;
        }else{
            return mayResult;
        }
    }
}
