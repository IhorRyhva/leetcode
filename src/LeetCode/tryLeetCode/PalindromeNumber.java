package LeetCode.tryLeetCode;

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(-22));
    }

    public boolean isPalindrome(int x) {
        String number = x + "";
        StringBuilder reversedNumber = new StringBuilder(number);
        return number.equals(reversedNumber.reverse().toString());
    }
}
