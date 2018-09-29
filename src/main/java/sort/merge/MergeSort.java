package sort.merge;

import sort.Sort;
import sort.SortUtils.Utils;

import java.util.Arrays;

/**
 * @描述
 * @创建人 caoxin
 * @创建时间 2018/9/28
 * @修改人和其它信息
 *
 * 递归的时间复杂度求解：T(N) = aT(n/b)+ n^d
 * 1.a:递归生成的子问题数        2  ==》a = 2
 * 2.每次递归是原来1/b的规模     2  ==》b = 2
 * 3.n^d为除了递归外，话费的事件  2n ==》d = 1
 *
 * logba = 1   d = n^1
 * logba = d ===>  d*logn  ==> n*logn
 *
 *
 * logba > d  ===> n^logba
 *
 * logba < d  ===> d
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] arr) {
        mergeSort(arr);
    }

    public static void mergeSort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2){
            return;
        }
        //1.终止条件
        if (left == right){
            return;
        }
        int middle = (left + right) >> 1;
        //原来的一个问题，递归成两个子问题
        mergeSort(arr,left,middle);
        mergeSort(arr,middle+1,right);
        sort(arr,left,middle,right);
    }

    private static void sort(int[] arr, int left, int middle, int right) {
        int returnLeft = left;
        int returnRight = middle + 1;
        int start = 0;
        //1.确定需要比较的数组的范围大小
        int[] mergeArr = new int[right-left+1];

        //2.下标为两个值之间赋值
        while (returnLeft <= middle && returnRight <= right){
            mergeArr[start++] =
                    arr[returnLeft] > arr[returnRight]?
                            arr[returnRight++]:arr[returnLeft++];
        }
        //3.左右区间中一个区间一间用完了,排除另外一个区间
        while(returnLeft <= middle){
            mergeArr[start++] = arr[returnLeft++];
        }

        while(returnRight <= right){
            mergeArr[start++] = arr[returnRight++];
        }

        //4.保存merge的值到原来的数组中
        for (start = 0; start < mergeArr.length; start++){
            arr[start+left] = mergeArr[start];
        }
    }

    public static void main(String[] args) {
        Utils.testSortTemplate(new MergeSort());
    }
}
