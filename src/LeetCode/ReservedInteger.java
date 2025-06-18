package LeetCode;


public class ReservedInteger {

    public static void main(String[] args) {
        ReservedInteger integer = new ReservedInteger();
        System.out.println(integer.reverse(-2147483648));
    }

    public int reverse(int x) {
        boolean positive = x > 0;
        if(x == 0){
            return x;
        }

        while (x % 10 == 0){
            x /= 10;
        }
        StringBuilder builder = new StringBuilder();
        if(positive){
            builder.append(x).reverse();
        }else{
            x *= -1;
            builder.append(x).reverse();
        }

        if(positive){
            try{
                return Integer.parseInt(builder.toString());
            }catch (NumberFormatException e){
                return 0;
            }
        }else{
            try {
                return Integer.parseInt(builder.toString()) * -1;
            }catch (NumberFormatException e){
                return 0;
            }
        }
    }
}
