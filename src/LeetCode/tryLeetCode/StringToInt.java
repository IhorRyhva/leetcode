package LeetCode.tryLeetCode;

public class StringToInt {

    public static void main(String[] args) {
        StringToInt toInt = new StringToInt();
        System.out.println(toInt.myAtoi("  +  55"));
    }

    public int myAtoi(String s) {
        boolean hasSymbol = false;
        boolean toNegative = false;
        boolean hasDigit = false;
        char[] array = s.toCharArray();
        StringBuilder futureInteger = new StringBuilder();

        for(int i = 0; i < array.length; i++){
            if(array[i] == ' ' && !hasDigit && !hasSymbol){
                continue;
            }else if(array[i] == '-' && !hasSymbol && !hasDigit){
                hasSymbol = true;
                toNegative = true;
            } else if (array[i] == '+' && !hasSymbol && !hasDigit) {
                hasSymbol = true;
                continue;
            } else if(Character.isDigit(array[i])){
                hasDigit = true;
                futureInteger.append(array[i]);
            }else{
                break;
            }
        }

        int result = 0;
        try{
            result = Integer.parseInt(futureInteger.toString());
        }catch (NumberFormatException e){
            if(!hasDigit){
                return 0;
            }

            if(toNegative){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }

        return toNegative? result * -1: result;
    }
}
