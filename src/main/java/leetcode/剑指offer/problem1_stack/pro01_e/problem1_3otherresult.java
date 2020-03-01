package leetcode.剑指offer.problem1_stack.pro01_e;

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
public class problem1_3otherresult {
}
class CQueue1 {

    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    public CQueue1() {

    }

    public  void appendTail(int value) {
        stackA.push(value);
    }

    public  int deleteHead() {
        if (stackB.isEmpty()){
            while (!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }


        return stackB.isEmpty() ? -1 : stackB.pop();
    }
}