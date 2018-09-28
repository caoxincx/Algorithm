package sort.merge;

/**
 * 最原始版本
 */
public class MergeOfCX {
    public static int mergeSort(int left, int right,int[] arr,int[] newArr){

        if (arr == null || arr.length < 2){
            return 0;
        }
        if (left == right){
            return left;
        }
        int middle = (left+right) >> 1;
        //1.左边分隔
        int returnLeft = mergeSort(left, middle,arr,newArr);
        //2.右边分隔
        int newLeft = middle+1;
        int returnRight = mergeSort(newLeft, right,arr,newArr);

        //需要排序的范围
        int i = returnLeft;
        //返回值分别为左右指针（returnLeft，returnRight）
        //这里主要做的是：左右两个区间的大小的比较
        while(returnLeft <= middle && returnRight <= right){
            if (arr[returnLeft] > arr[returnRight]){
                newArr[i++] = arr[returnRight++];
            }else {
                newArr[i++] = arr[returnLeft++];
            }
        }
        /**
         * 下面两个while做的是当左区间，或者右区间比较完后剩下一个区间的时候
         * 该区间自己本身有序，所以直接排序赋值
         */

        while (returnLeft <= middle){
            newArr[i++] = arr[returnLeft++];
        }
        while (returnRight <= right){
            newArr[i++] = arr[returnRight++];
        }
        //需要保存原来排序完需要的值(0,1)[left,right]为指针的坐标
        for (int j = left; j <= right; j++){
            arr[j] = newArr[j];
        }
        return left;
    }


}
