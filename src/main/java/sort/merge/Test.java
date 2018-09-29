package sort.merge;

import sort.Sort;
import sort.SortUtils.Utils;

import java.util.Arrays;

/**
 * @描述
 * @创建人 caoxin
 * @创建时间 2018/9/29
 * @修改人和其它信息
 */
public class Test implements Sort {
    /**
     * 手撸递归排序
     */
    public static void mergeSort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2){
            return;
        }
        if (left == right){
            return;
        }
        int middle = (left + right) >> 1;
        mergeSort(arr,left,middle);
        mergeSort(arr,middle+1,right);
        merge(arr,left,middle,right);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int returnLeft = left;
        int returnRight = middle+1;
        int start = 0;
        int[] copyArr = new int[right-left+1];

        while (returnLeft <= middle && returnRight <= right){
            copyArr[start++] = arr[returnLeft] < arr[returnRight] ?
                    arr[returnLeft++]: arr[returnRight++];
        }
        while (returnLeft <= middle) {
            copyArr[start++] = arr[returnLeft++];
        }
        while (returnRight <= right) {
            copyArr[start++] = arr[returnRight++];
        }

        for (start=0; start < copyArr.length; start++){
            arr[start+left] = copyArr[start];
        }
    }


    public static void main(String[] args) {
        Utils.testSortTemplate(new Test());
    }

    @Override
    public void sort(int[] arr) {
        mergeSort(arr);
    }



}
