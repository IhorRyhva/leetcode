package LeetCode.firstMonth;

public class IsSubsequence {

    public static void main(String[] args){
        IsSubsequence subsequence = new IsSubsequence();
        System.out.println(subsequence.isSubsequence("aec", "abcde"));
    }

    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;

        char[] mainString = t.toCharArray();
        char[] subsequence = s.toCharArray();

        int flag = 0;
        for(int i = 0; i < subsequence.length; i++){
            boolean contains = false;
            for (int j = flag; j < mainString.length; j++) {
                if(subsequence[i] == mainString[j]){
                    flag = j + 1;
                    contains = true;
                    break;
                }
            }
            if(!contains){
                return false;
            }
        }
        return true;
    }
}
