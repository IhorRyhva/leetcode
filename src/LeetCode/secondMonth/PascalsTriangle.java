package LeetCode.secondMonth;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        PascalsTriangle triangle = new PascalsTriangle();
        triangle.generate(5).forEach(subTriangle -> subTriangle.forEach(System.out::print));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int size = 0; size < numRows; size++) {
            if(size == 0){
                ArrayList<Integer> element = new ArrayList<>();
                element.add(1);
                result.add(element);
            }else {
                List<Integer> lastTriangle = result.get(result.size() - 1);
                ArrayList<Integer> newTriangle = new ArrayList<>();
                for (int i = 0; i < lastTriangle.size(); i++) {
                    if (i == 0) {
                        newTriangle.add(1);
                        if(lastTriangle.size() == 1) newTriangle.add(1);
                    } else if (i == lastTriangle.size() - 1) {
                        newTriangle.add(lastTriangle.get(i - 1) + lastTriangle.get(i));
                        newTriangle.add(lastTriangle.get(i));
                    } else {
                        newTriangle.add(lastTriangle.get(i - 1) + lastTriangle.get(i));
                    }
                }
                result.add(newTriangle);
            }
        }
        return result;
    }

}
