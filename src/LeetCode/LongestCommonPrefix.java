package LeetCode;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        System.out.println(prefix.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        char partOfPrefix;
        boolean stop = false;

        String start = strs[0];
        for(int i = 0; i < start.length(); i++){
            partOfPrefix = start.charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length()){
                    stop = true;
                    break;
                }
                if(strs[j].charAt(i) != partOfPrefix){
                    stop = true;
                }
            }
            //Check
            if(stop){
                break;
            }else{
                builder.append(partOfPrefix);
            }
        }

        return builder.toString();
    }
}
