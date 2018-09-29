package sort.quick;

import sort.Sort;
import sort.SortUtils.Utils;

import java.util.Arrays;

/**
 * @描述
 * @创建人 caoxin
 * @创建时间 2018/9/28
 * @修改人和其它信息
 */
public class Partition implements Sort {

    @Override
    public void sort(int[] arr) {

    }
    /**
     * 将一个数组按数组最后一个元素分成<区，>=区两个区间
     * 时间复杂度为O(N),空间复杂为0
     * @param arr
     */


    public static void partition(int[] arr, int compartor){

       int index = 0;
       int smallZone = -1;
       while (index < arr.length){
           if (arr[index] < compartor){
               Utils.swap(arr,index++,++smallZone);
           }else {
               index++;
           }
       }
    }



    public static void main(String[] args) {
        int[] arr = {1,5,3,2,6,4};
        partition(arr,4);
        System.out.println(Arrays.toString(arr));
    }


}
