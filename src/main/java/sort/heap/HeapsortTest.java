package sort.heap;

import sort.Sort;
import sort.SortUtils.Utils;

import javax.rmi.CORBA.Util;
import java.util.Arrays;

/**
 * @描述
 * @创建人 caoxin
 * @创建时间 2018/9/30
 * @修改人和其它信息
 */
public class HeapsortTest implements Sort {
    /**
     * 使用数组构造一颗完全二叉树（最大堆）
     * @param arr
     */
    public static void heapInsert(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int child = i;
            int par = (i - 1) >> 1;

            while (par >= 0){
                if (arr[child] > arr[par]){
                    Utils.swap(arr,child,par);
                }
                child = par;
                par = (par - 1) >> 1;
            }
        }
    }

    /**
     * 第一个元素与index元素互换，将第一个元素下沉到合适它的位置。重复这个过程
     * 重复判断需要解决一下
     * @param arr
     */
    public static void heapify(int[] arr){
        int index = arr.length - 1;
        while (index > 0){

            int swapIndex = 0;
            Utils.swap(arr,swapIndex,index);

            int leftChild = 2*swapIndex + 1;
            int rightchild = 2*swapIndex + 2;

            int large = leftChild < index ?
                            rightchild < index ?
                                    arr[leftChild]>arr[rightchild] ? leftChild:rightchild:leftChild:rightchild;
            while (large < index && arr[large] > arr[swapIndex]){

                Utils.swap(arr,swapIndex,large);

                swapIndex = large;
                leftChild = 2*swapIndex + 1;
                rightchild = 2*swapIndex + 2;

                large = leftChild < index ?
                        rightchild < index ?
                                arr[leftChild]>arr[rightchild] ? leftChild:rightchild:leftChild:rightchild;
            }
            index--;
        }
    }

    public static void heapSort(int[] arr){
        heapInsert(arr);
        heapify(arr);
    }
    public static void main(String[] args) {
        //测试
        Utils.testSortTemplate(new HeapsortTest());
    }

    @Override
    public void sort(int[] arr) {
        heapSort(arr);
    }
}
