package LeetCode.tryLeetCode;

import java.util.ArrayList;
import java.util.Collections;


public class Median {
    public static void main(String[] args) {
        Median fourth = new Median();
        int[] i = {1,2};
        int[] o = {3, 4};

        System.out.println(fourth.findMedianSortedArrays(i, o));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> merged = new ArrayList<>();
        addToList(merged, nums1, nums2);

        if(merged.size() % 2 == 0){
            int firstIndex = merged.size() / 2;
            int secondIndex = firstIndex - 1;
            double first = merged.get(firstIndex);
            double second = merged.get(secondIndex);

            double result = (first + second) / 2;
            return result;
        }else{
            int index = (merged.size() / 2);
            return merged.get(index);
        }
    }

    public static ArrayList<Integer> addToList(ArrayList<Integer> result, int[] array1, int[] array2){
        for(int i: array1){
            result.add(i);
        }
        for(int i: array2){
            result.add(i);
        }
        Collections.sort(result);
        return result;
    }
}
