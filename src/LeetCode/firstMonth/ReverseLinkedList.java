package LeetCode.firstMonth;

import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        ListNode listNode = new ListNode(1);
        ListNode next = new ListNode(2);
        listNode.next = next;
        list.reverseList(listNode);
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        Stack<ListNode> stack = getStack(head);

        ListNode node = stack.pop();
        ListNode tempNext = stack.pop();
        node.next = tempNext;
        if(stack.empty()){
            tempNext.next = null;
        }

        extracted(stack, tempNext);
        return node;
    }

    private void extracted(Stack<ListNode> stack, ListNode tempNext) {
        while(!stack.empty()){
            ListNode next = stack.pop();
            tempNext.next = next;
            tempNext = next;

            if(stack.empty()){
                tempNext.next = null;
            }
        }
    }


    private Stack<ListNode> getStack(ListNode node){
        Stack<ListNode> stack = new Stack<>();
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        return stack;
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
