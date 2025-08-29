package sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class QuickSort {
//    public static void main(String[] args) throws InterruptedException {
//        int[] notSotred = new int[50];
//        for (int i = 0; i < notSotred.length; i++) {
//            if(i == 0) System.out.print("{");
//            notSotred[i] = ThreadLocalRandom.current().nextInt(0, 1000);
//            if(i == notSotred.length - 1) {
//                System.out.print(notSotred[i]);
//                System.out.print("}");
//            }else {
//                System.out.print(notSotred[i] + ", ");
//            }
//            Thread.sleep(100);
//        }
//        System.out.println();
//        quickSort(notSotred, 0, notSotred.length - 1);
//        for (int i = 0; i < notSotred.length; i++) {
//            if(i == 0) System.out.print("{");
//            if(i == notSotred.length - 1) {
//                System.out.print(notSotred[i]);
//                System.out.print("}");
//            }else {
//                System.out.print(notSotred[i] + ", ");
//            }
//            Thread.sleep(100);
//        }
//    }

    private static void quickSort(int[] notSotred, int start, int end) {
        if(start >= end) return;
        int pivot = getPivot(notSotred, start, end);
        quickSort(notSotred, start, pivot - 1);
        quickSort(notSotred, pivot + 1, end);
    }

    private static int getPivot(int[] notSotred, int start, int end) {
        int i = start - 1;
        int pivot = notSotred[end];
        for (int j = start; j < end; j++) {
            if(notSotred[j] < pivot){
                i++;
                int temp = notSotred[i];
                notSotred[i] = notSotred[j];
                notSotred[j] = temp;
            }
        }
        i++;
        int temp = notSotred[end];
        notSotred[end] = notSotred[i];
        notSotred[i] = temp;
        return i;
    }
}
