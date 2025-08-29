package LeetCode.secondMonth;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 2};
        int target = 11;
        System.out.println(minSubArrayLen(target, nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target){
                minLen = Math.min(right - left + 1, minLen);
                sum -= nums[left];
                left++;
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen: 0;
    }
}
