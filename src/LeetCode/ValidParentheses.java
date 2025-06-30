package LeetCode;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("("));
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> openChars = new Stack<>();
        int countOpen = 0;
        int countClose = 0;

        for(int i = 0; i < chars.length; i++){
            if(isOpen(chars[i])){
                openChars.push(chars[i]);
                countOpen++;
            }else{
                if(openChars.size() == 0 || openChars.pop() != toOpen(chars[i])){
                    return false;
                }
                countClose++;
            }
        }
        if(openChars.size() > 0 || countOpen != countClose){
            return false;
        }
        return true;
    }
    private Character toOpen(char aChar) {
        if(aChar == ')'){
            return '(';
        }else if(aChar == ']'){
            return '[';
        }else if(aChar == '}'){
            return '{';
        }else{
            return 0;
        }
    }

    private boolean isOpen(char validChar) {
        if(validChar == '(' || validChar == '[' || validChar == '{'){
            return true;
        }
        return false;
    }

}
