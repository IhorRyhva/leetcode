package LeetCode;

public class ZigZag {

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        System.out.println(zigZag.convert("PAYPALISHIRING", 4));
    }
    public String convert(String s, int numRows) {
        String[][] array = new String[numRows][s.length()];
        boolean increase = true;
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(increase){
                if(count < numRows - 1){
                    array[count][i] = s.charAt(i) + "";
                    count++;
                }else{
                    if(count >= array.length){
                        count = array.length - 1;
                    }
                    array[count][i] = s.charAt(i) + "";
                    increase = false;
                }
            }else{
                if(count > 1){
                    count --;
                    array[count][i] = s.charAt(i) + "";
                }else{
                    if(count > 0) {
                        count--;
                    }
                    array[count][i] = s.charAt(i) + "";
                    increase = true;
                    count++;
                }
            }
        }

        return convertToString(array);
    }

    private String convertToString(String[][] array){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] != null){
                    builder.append(array[i][j]);
                }
            }
        }
        return builder.toString();
    }
}
