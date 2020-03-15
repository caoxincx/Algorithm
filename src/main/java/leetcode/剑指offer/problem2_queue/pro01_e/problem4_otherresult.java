package leetcode.剑指offer.problem2_queue.pro01_e;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/15
 * 功能描述:快速排序方法
 * 修改日期:2020/3/15
 * 修改描述:
 */
public class problem4_otherresult {
}
class QuickSort{
    public static void sort(int[] arr,int start,int end) {
        if (start < end) {
            int[] partition = partition(arr, start, end);
            sort(arr,start,partition[0]);
            sort(arr,partition[1],end);
        }
    }

    public static int[] partition(int[] arr, int start, int end) {
        int compartor = Compartor(arr, start, end);
        int smallZone = start - 1;
        int bigZone = end + 1;
        while (start < bigZone) {
            if (arr[start] < compartor) {
                swap(arr,++smallZone,start++);
            } else if (arr[start] > compartor) {
                swap(arr,--bigZone,start);
            }else {
                start++;
            }
        }
        return new int[]{smallZone,bigZone};
    }

    public static int Compartor(int[] arr, int start, int end) {
        TreeSet<Integer> treeMap = new TreeSet<>();
        treeMap.add(arr[start]);
        treeMap.add(arr[end]);
        treeMap.add(arr[(start+end)>>1]);
        return treeMap.pollFirst();
    }
    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 9, 7, 5};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
