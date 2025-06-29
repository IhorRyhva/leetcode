package LeetCode.tryLeetCode;


public class ContainerWithMosWater {
    public static void main(String[] args) {
        ContainerWithMosWater containerWithMosWater = new ContainerWithMosWater();
        int[] array = {1,2,3,4,5,25,24,3,4};
        System.out.println(containerWithMosWater.maxArea(array));
    }

    public int maxArea(int[] height) {
        int right = 0;
        int left = height.length - 1;
        int width = left - right;
        int area = Integer.min(height[left], height[right]) * width;
        while (right != left){
            width = left - right;
            area = Integer.max(area, Integer.min(height[left], height[right]) * width);

            if(height[right] > height[left]){
                left--;
            }else{
                right++;
            }
        }
        return area;
    }
}
