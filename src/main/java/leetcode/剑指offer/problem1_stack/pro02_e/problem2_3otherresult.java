package leetcode.剑指offer.problem1_stack.pro02_e;

import java.util.Stack;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/1
 * 功能描述:空间换时间 双栈
 * 修改日期:2020/3/1
 * 修改描述:
 */
public class problem2_3otherresult {
}
class MinStack2 {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack2() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);

        if (x < min) {
            min = x;
        }

        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
