package leetcode.剑指offer.problem1_stack.pro01_e;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/1
 * 功能描述:
 * 修改日期:2020/3/1
 * 修改描述:
 */
public class problem1_2myresult {
}
class CQueue {
    private Stack stackA = new Stack();
    private Stack stackB = new Stack();
    static class Node {
        public Node next;
        public int value;
        public Node(int value,Node next){
            this.next = next;
            this.value = value;
        }
    }
    static class Stack {
        public Node head;
        public void append(int i){
            if(head == null){
                Node node = new Node(i,null);
                head = node;
            }else{
                Node node = new Node(i,head);
                head = node;
            }
        }
        public int pop(){
            if(head == null){
                return -1;
            }else{
                Node node = head;
                head = head.next;
                return node.value;
            }
        }
        public boolean isNull(){
            return head == null;
        }
    }

    public CQueue() {}



    public void appendTail(int value) {
        stackA.append(value);

    }

    public int deleteHead() {
        if(stackA.isNull() && stackB.isNull()){
            return -1;
        }
        if(stackB.isNull()){
            int i = -99999;
            while((i = stackA.pop()) != -1){
                stackB.append(i);
            }
        }
        return stackB.pop();
    }
}
