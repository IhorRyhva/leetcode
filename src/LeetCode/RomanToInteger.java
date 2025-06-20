package LeetCode;

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        char[] romanNumbers = s.toCharArray();
        int result = 0;
        int till = romanNumbers.length;

        for(int i = 0; i < till; i++){
            if(i != till - 1 && getNumber(romanNumbers[i]) < getNumber(romanNumbers[i + 1])){
                result += getNumber(romanNumbers[i + 1]) - getNumber(romanNumbers[i]);
                i += 1;
            }else{
                result += getNumber(romanNumbers[i]);
            }
        }
        return result;
    }

    private int getNumber(Character character){
        if(character == 'I'){
            return 1;
        } else if (character == 'V') {
            return 5;
        } else if (character == 'X') {
            return 10;
        } else if (character == 'L') {
            return 50;
        } else if (character == 'C') {
            return 100;
        } else if (character == 'D') {
            return 500;
        } else if (character == 'M') {
            return 1000;
        }else{
            throw new IllegalArgumentException();
        }
    }
}
