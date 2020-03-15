package leetcode.剑指offer.problem2_queue.pro01_e;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/15
 * 功能描述:利用java实现了有限队列，内部就是堆的实现
 * 修改日期:2020/3/15
 * 修改描述:
 */
public class problem2_myresult {
}
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int retArr[] = new int[k];
        if(arr == null || arr.length == 0 || k <= 0){
            return retArr;
        }
        if(k >= arr.length){
            return arr;
        }
        minHeap.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        for(int i = 0; i < k; i++){
            retArr[i] = minHeap.poll();
        }
        return retArr;
    }
}
