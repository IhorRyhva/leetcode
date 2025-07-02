package LeetCode.firstMonth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode forTest1 = list1;

        ListNode list2 = new ListNode(1);
        ListNode forTest2 = list2;

        for (int i = 0; i < 10; i++) {
            int val = ThreadLocalRandom.current().nextInt(1, 100);
            ListNode next = new ListNode(val);
            list1.next = next;
            list1 = next;
        }

        for (int i = 0; i < 15; i++) {
            int val = ThreadLocalRandom.current().nextInt(1, 100);
            ListNode next = new ListNode(val);
            list2.next = next;
            list2 = next;
        }
        ListNode node = new MergeTwoSortedLists().mergeTwoLists(forTest1, forTest2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode mergedNode = getNode(list1, list2);
        return mergedNode;
    }


    private ListNode getNode(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode result = merged;
        ArrayList<Integer> integers = new ArrayList<>();

        while (list1 != null){
        integers.add(list1.val);
        list1 = list1.next;
        }
        while (list2 != null){
        integers.add(list2.val);
        list2 = list2.next;
        }
       Collections.sort(integers);
       merged.val = integers.get(0);

        for (int i = 1; i < integers.size(); i++) {
            ListNode next = new ListNode(integers.get(i));
            merged.next = next;
            merged = next;
        }
        return result;
    }


    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
   }
}
