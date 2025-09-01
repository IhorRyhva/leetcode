package LeetCode.secondMonth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(1000));
    }

    HashMap<Integer, Integer> savedResult = new HashMap<>();
    public int climbStairs(int n) {
        int result = 0;
        if(n <= 1) result = 1;
        else if(savedResult.containsKey(n)){
            result = savedResult.get(n);
        }
        else{
            result = climbStairs(n - 1) + climbStairs(n - 2);
            savedResult.put(n, result);
        }

        return result;
    }

}
