package sort.merge;

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
public class MergeSort {
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
        merge(arr,left,middle,right);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
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

    /**
     * 比较器：对数器
     * @param arr1 数组1
     * @return
     */
    public static void compartor(int[] arr1){
        Arrays.sort(arr1);
    }

    /**
     * 数组复制
     * @param arr
     * @return
     */
    public static int[] copyArr(int[] arr){
        if (arr == null) {
            return null;
        }
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    /**
     * 获取最大值和大小随机的数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize) * Math.random()+ 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue) * Math.random() + 1) - (int) (maxValue * Math.random()+ 1);
        }
        return arr;
    }

    /**
     * 判断两个数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int maxValue = 100;
        int maxSize = 100;
        int timeOut = 10000;
        for (int i = 0; i < timeOut; i++){

            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArr(arr1);


            compartor(arr1);
            mergeSort(arr2);


            if (!isEqual(arr1,arr2)){
                System.out.println("fucking fuck!!!");
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                return;
            }
        }
        System.out.println("right!!!");
    }
}
