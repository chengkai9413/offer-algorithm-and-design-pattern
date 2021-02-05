package learn.sword.to.offer;

import learn.sword.to.offer.model.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Solution6LinkListPrintReverse {

    /**
     * 思路：栈
     * 注意：递归的话，可能会造成栈溢出，用循环实现更好
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null) return null;
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = listNode;
        while(tmp.next != null){
            stack.push(tmp.val);
            tmp = tmp.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;


    }


    public static void main(String[] args) {

    }
}
