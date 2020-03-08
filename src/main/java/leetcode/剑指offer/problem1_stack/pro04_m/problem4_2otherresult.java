package leetcode.剑指offer.problem1_stack.pro04_m;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/8
 * 功能描述:题解:https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/ru-he-jie-jue-o1-fu-za-du-de-api-she-ji-ti-by-z1m/
 * 解决的问题:队头丢失元素问题
 * 解决方法:辅助队列中如果后进元素大于队尾元素,则弹出直到辅助队列的元素大于队尾
 * 修改日期:2020/3/8
 * 修改描述:
 */
public class problem4_2otherresult {
}

class MaxQueue {
    private Deque<Integer> deque = new ArrayDeque<>();
    private Deque<Integer> helpDeque = new ArrayDeque<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (deque.size() == 0) return -1;
        else return helpDeque.peek();
    }

    public void push_back(int value) {
        deque.offer(value);
        while (helpDeque.size() > 0 && value > helpDeque.peekLast()) {
            helpDeque.pollLast();
        }
        helpDeque.offer(value);
    }

    public int pop_front() {
        if (deque.size() == 0) return -1;
        int value = deque.poll();
        if (helpDeque.peek() == value) helpDeque.poll();
        return value;
    }
}

