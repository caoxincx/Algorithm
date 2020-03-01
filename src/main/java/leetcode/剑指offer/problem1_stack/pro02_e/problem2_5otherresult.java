package leetcode.剑指offer.problem1_stack.pro02_e;

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
public class problem2_5otherresult {
}
class MinStack5 {
    private Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack5() {

    }

    public void push(int x) {
        //先压先前最小值
        //再压一个当前最小值，保证最小值一直存在
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}