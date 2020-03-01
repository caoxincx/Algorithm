package leetcode.剑指offer.problem1_stack.pro02_e;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/1
 * 功能描述:
 * 修改日期:2020/3/1
 * 修改描述:
 */
public class problem2_2myresult {
}
class MinStack {
    private Stack<Integer> stack = new Stack();
    private LinkedList<Integer> list = new LinkedList();
    private int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(x < min) min = x;
        list.add(x);
    }

    public void pop() {
        int result = stack.pop();
        if(result == min){
            Collections.sort(list);
            list.pollFirst();
            min = list.peekFirst();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
