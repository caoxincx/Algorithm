package leetcode.剑指offer.problem2_queue.pro01_e;

import sort.SortUtils.Utils;

import java.util.Arrays;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/15
 * 功能描述:自定义堆实现
 * 修改日期:2020/3/15
 * 修改描述:
 */
public class problem3_otherresult {
    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 9, 7, 5};
        new Minheap().buildMinHead(arr);
        System.out.println(Arrays.toString(arr));
        new Minheap().heapify(arr);
        System.out.println(Arrays.toString(arr));

    }
}
class Minheap{
    public void buildMinHead(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int child = i;
            int par = (i - 1) >> 1;
            while(par >= 0){
                if (arr[child] > arr[par]){
                    Utils.swap(arr,child,par);
                }
                child = par;
                par = (par - 1) >> 1;
            }
        }
    }

    public void heapify(int arr[]) {
        int index = arr.length -1;
        while (index > 0) {
            // 将头元素与尾部元素互换
            int swapIndex = 0;
            Utils.swap(arr,swapIndex,index);
            // 下沉过程
            int leftChild = leftChild(swapIndex);
            int rightChild = rightChiled(swapIndex);


            int large =
                    leftChild < index ?
                    rightChild < index ?
                    arr[leftChild] < arr[rightChild] ?rightChild:leftChild:leftChild:rightChild;
            while (large < index && arr[large] > arr[swapIndex]){
                Utils.swap(arr,large,swapIndex);
                swapIndex = large;
                leftChild = leftChild(swapIndex);
                rightChild = rightChiled(swapIndex);
                large =
                        leftChild < index ?
                        rightChild < index ?
                        arr[leftChild] < arr[rightChild] ?rightChild:leftChild:leftChild:rightChild;
            }
            index--;
        }
    }
    public int leftChild(int i) {
        return (i << 1) + 1;
    }

    public int rightChiled(int i) {
        return (i << 1) + 2;
    }

}

