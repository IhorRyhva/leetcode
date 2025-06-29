package LeetCode.tryLeetCode;

public class IntToRoman {
    public static void main(String[] args) {
        IntToRoman roman = new IntToRoman();
        System.out.println(roman.intToRoman(3749));
    }

    public String intToRoman(int num) {
        int thousands = num / 1000;
        num = num - (1000 * thousands);
        int hundreds = (num / 100);
        num = num - (100 * hundreds);
        int tens = (num / 10);
        num = num - (10 * tens);
        int numbers = num;

        StringBuilder builder = new StringBuilder();
        getThousands(builder, thousands);
        getHundreds(builder, hundreds);
        getTens(builder, tens);
        getNumbers(builder, numbers);

        return builder.toString();
    }


    private void getThousands(StringBuilder builder, int thousands) {
        while (thousands > 0){
            builder.append("M");
            thousands--;
        }
    }

    private void getHundreds(StringBuilder builder, int hundreds) {
        while (hundreds > 0){
            if(hundreds == 9){
                builder.append("CM");
                hundreds -= 9;
            } else if (hundreds >= 5) {
                builder.append("D");
                hundreds -= 5;
            }else if(hundreds == 4){
                builder.append("CD");
                hundreds -= 4;
            }else{
                builder.append("C");
                hundreds--;
            }
        }
    }

    private void getTens(StringBuilder builder, int tens) {
        while (tens > 0){
            if(tens == 9){
                builder.append("XC");
                tens -= 9;
            }else if(tens >= 5){
                builder.append("L");
                tens -= 5;
            }else if(tens == 4){
                builder.append("XL");
                tens -= 4;
            }else{
                builder.append("X");
                tens--;
            }
        }
    }

    private void getNumbers(StringBuilder builder, int numbers) {
        while (numbers > 0){
            if(numbers == 9){
                builder.append("IX");
                numbers -= 9;
            }else if(numbers >= 5){
                builder.append("V");
                numbers -= 5;
            }else if(numbers == 4){
                builder.append("IV");
                numbers -= 4;
            }else{
                builder.append("I");
                numbers--;
            }
        }
    }
}
