package leetcode.剑指offer.problem1_stack.pro02_e;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/1
 * 功能描述:使用一种新数据结构解决问题
 * 修改日期:2020/3/1
 * 修改描述:
 */
public class problem2_4otherresult {
}
class MinStack3{
    private Node head;

    public MinStack3() {

    }

    public void push(int x) {

        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(head.min, x), head);
    }

    public void pop() {

        head = head.next;
    }

    public int top() {

        return head.val;
    }

    public int min() {

        return head.min;
    }

    private class Node {

        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {

            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
