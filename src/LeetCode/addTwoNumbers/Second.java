package LeetCode.addTwoNumbers;

import java.math.BigInteger;

public class Second {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 2;
        ListNode l12 = new ListNode();
        l12.val = 4;
        l1.next = l12;
        ListNode l13 = new ListNode();
        l13.val = 3;
        l12.next = l13;

        ListNode l2 = new ListNode();
        l2.val = 5;
        ListNode l22 = new ListNode();
        l22.val = 6;
        l2.next = l22;
        ListNode l23 = new ListNode();
        l23.val = 4;
        l22.next = l23;

        System.out.println(fromNodeTotring(new Second().addTwoNumbers(l1, l2)));
    }

    private static String fromNodeTotring(ListNode listNode) {
        StringBuilder builder = new StringBuilder();
        ListNode node = listNode;
        while (node != null){
            builder.append(node.val);
            node = node.next;
        }
        return builder.toString();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger number1 = getNumber(l1);
        BigInteger number2 = getNumber(l2);

        BigInteger result = number1.add(number2);
        return toListNode(result);
    }

    private ListNode toListNode(BigInteger result) {
        StringBuilder builder = new StringBuilder();
        builder.append(result).reverse();
        String[] array = builder.toString().split("");
        return fromArrayToList(array);
    }

    private ListNode fromArrayToList(String[] array) {
        ListNode result = new ListNode();
        ListNode current = new ListNode();
        ListNode next;
        for(int i = 0; i < array.length; i++){
           if(i == 0){
               result.val = Integer.parseInt(array[i]);
               current = result;
           }else{
               next = new ListNode();
               next.val = Integer.parseInt(array[i]);
               current.next = next;
               current = next;
           }
        }
        return result;
    }

    private BigInteger getNumber(ListNode l1) {
        StringBuilder s = new StringBuilder();
        ListNode temp = l1;
        while (temp != null){
            s.append(temp.val);
            temp = temp.next;
        }
        s.reverse();
        BigInteger result = new BigInteger(s.toString());
        return result;
    }
}
