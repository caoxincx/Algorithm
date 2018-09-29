package sort.quick;

import sort.Sort;

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
     * 将一个数组按数组最后一个元素分成<=区，>区两个区间
     * 时间复杂度为O(N),空间复杂为0
     * @param arr
     */
    public static void quickSort(int[] arr){

        int smallZone = -1;
        int bigZone = arr.length-1;

        partition(arr, smallZone, bigZone);


    }

    public static void partition(int[] arr, int smallZone, int bigZone){

        int middle = arr[bigZone];
        int left = smallZone;
        int right = bigZone;

        while (smallZone < bigZone){
            while (arr[++smallZone] < middle){
                if (arr[smallZone] > middle){
                    break;
                }
            }
            while (arr[--bigZone] > middle){
                if (arr[bigZone] < middle){
                    break;
                }
            }
            if (smallZone < bigZone){
                swap(arr,smallZone,bigZone);
            }
        }
    }

    /**
     * 两个数组之间的元素交换
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,2,6,4};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
