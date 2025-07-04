package LeetCode.tryLeetCode;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(twoSum(nums, 9)[0]);
    }

    public static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            int someNumber = target - nums[i];

            for(int j = i + 1; j < nums.length; j++){
                if(someNumber == nums[j]){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }
}
