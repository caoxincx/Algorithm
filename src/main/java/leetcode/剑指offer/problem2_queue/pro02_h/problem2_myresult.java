package leetcode.剑指offer.problem2_queue.pro02_h;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/15
 * 功能描述:数组排序暴力破解
 * 修改日期:2020/3/15
 * 修改描述:
 */
public class problem2_myresult {
}
class MedianFinder {
    List<Integer> list = new ArrayList();

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        if(list.size() % 2 == 0 ){
            return ((double)list.get(list.size()/2) + (double)list.get((list.size()/2)-1))/2;
        }else{
            return (double)list.get((list.size()));
        }
    }
}

