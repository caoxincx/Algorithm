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
     * 时间复杂度分析：
     * T(N) = 2T(n/2)+n
     * a = 2
     * b = 2
     * d = n
     * logba > d = n^logba
     * logba = d = d * logba = nlogn
     * logba < d = d
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2){
            return;
        }
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
        int comparator = Utils.getComparator(arr,left,right);
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



    public static void main(String[] args) {
        Utils.testSortTemplate(new QuickSort());
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr);
    }
}
