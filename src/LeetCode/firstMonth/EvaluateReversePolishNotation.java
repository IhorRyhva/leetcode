package LeetCode.firstMonth;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        EvaluateReversePolishNotation polishNotation = new EvaluateReversePolishNotation();
        String[] test = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(polishNotation.evalRPN(test));
    }

    public int evalRPN(String[] tokens){
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if(isDigit(tokens[i])){
                nums.push(Integer.parseInt(tokens[i]));
            }else{
                int num2 = nums.pop();
                int num1 = nums.pop();
                nums.push(operation(num1, num2, tokens[i].charAt(0)));
            }
        }
        return nums.pop();
    }

    private boolean isDigit(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private Integer operation(int num1, int num2, char operation){
        if(operation == '+'){
            return num1 + num2;
        }else if(operation == '-'){
            return num1 - num2;
        }else if(operation == '*'){
            return num1 * num2;
        } else if (operation == '/' && num2 != 0) {
            return num1 / num2;
        }else{
            throw new RuntimeException();
        }
    }

}
