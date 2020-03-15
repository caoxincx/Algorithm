package leetcode.剑指offer.problem2_queue.pro02_h;

import java.util.*;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/15
 * 功能描述:
 * 修改日期:2020/3/15
 * 修改描述:
 */
public class problem3_otherresult {
}
class MedianFinder2 {
    private Queue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
    private Queue<Integer> maxHeap = new PriorityQueue<>();
    int size;

    /** initialize your data structure here. */
    public MedianFinder2() {

    }

    public void addNum(int num) {
        size++;
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if ((size & 1) == 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if ((size & 1) == 1) return minHeap.peek();
        else return (minHeap.poll() + maxHeap.peek()) * 0.5;
    }
}

