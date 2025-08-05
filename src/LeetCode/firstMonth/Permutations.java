package LeetCode.firstMonth;


public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.fibonachi(7));
        System.out.println(permutations.fibonachiRec(7));
    }

    private int fibonachi(int flag){
        int first = 1;
        int second = 1;
        int result = 0;
        if(flag < 2){
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
    private int fibonachiRec(int flag){
        if(flag < 2){
            return 1;
        }else{
            return fibonachiRec(flag - 1) + fibonachiRec(flag - 2);
        }
    }

}
