package LeetCode.firstMonth;


public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.fibonachi(8));
    }

    private int fibonachi(int flag){
        int first = 0;
        int second = 1;
        int result = 0;
        if(flag < 3){
            return 1;
        }
        for (int i = 2; i < flag; i++) {
            int temp = first;
            first = second;
            second = first + temp;
            result = second + first;
        }
        return result;
    }

}
