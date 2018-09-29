package sort.quick;

import sort.Sort;
import sort.SortUtils.Utils;


/**
 * @描述 快速排序
 * @创建人 caoxin
 * @创建时间 2left18/9/29
 * @修改人和其它信息
 */
public class QuickSort implements Sort {
    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //1.执行分区
            int[] partition = partition(arr, left, right);
            //2.左边进行分区
            quickSort(arr, left, partition[0]);
            //3.右边进行分区
            quickSort(arr, partition[1], right);
        }
    }

    /**
     * 快速排序partition
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int[] partition(int[] arr,int left, int right){
        //1.【小于区】
        int smallZone = left - 1;
        //2.【大于区】
        int bigZone = right + 1;
        //3.随机 一个中位数的比较值
        int comparator = getComparator(arr,left,right);
        //4.partition：部分
        while(left < bigZone){
            if (arr[left] < comparator){
                Utils.swap(arr,left++,++smallZone);
            }else if (arr[left] > comparator){
                Utils.swap(arr,left,--bigZone);
            }else {
                left++;
            }
        }
        //5.返回两个大于等于区，小于等于区
        return new int[]{smallZone,bigZone};
    }

    /**
     * 获取数组中三个数的中间值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int getComparator(int[] arr,int left,int right){
        int middle = (right + left) >> 1;
        if (arr[left] > arr[middle]){
            return arr[left] > arr[right]?
                    arr[right] > arr[middle]?arr[right]:arr[middle]:arr[left];
        }else if (arr[left] < arr[middle]){
            return arr[middle] > arr[right]?
                    arr[right]>arr[left]?arr[right]:arr[left]:arr[middle];
        }else {
            return arr[left]>arr[middle]?arr[middle]:arr[left];
        }
    }

    public static void main(String[] args) {
        Utils.testSortTemplate(new QuickSort());
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr);
    }
}
