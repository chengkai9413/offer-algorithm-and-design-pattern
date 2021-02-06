package learn.sword.to.offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 要点：发现两个栈从一个到另一个的过程就是将所有元素逆序
 */
public class Solution9QueueBy2Stack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        // 空了之后，将stack2的栈顶pop出
        if (stack2.empty()) throw new RuntimeException("queue empty!");
        int res = stack2.pop();
        // 剩余的全部压回stack1
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }


    /**
     * 更好的解法：
     * stack2中仍然有数据的时候，说明栈顶未空，可以直接从stack2中 pop
     * 为空时，才需要一次性将stack1中的所有元素压入stack2，完成逆序
     *
     * @return
     */
    public int pop2() {
        if (stack2.empty() && stack1.empty()) throw new RuntimeException("queue empty!");
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        // 空了之后，将stack2的栈顶pop出
        return stack2.pop();
    }

}
