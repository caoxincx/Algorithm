package sort.SortUtils;

import sort.Sort;

import java.util.Arrays;

/**
 * @描述
 * @创建人 caoxin
 * @创建时间 2018/9/28
 * @修改人和其它信息
 */
public class Utils {
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


    public static void testSortTemplate(Sort sort){

        int maxValue = 100;
        int maxSize = 100;
        int timeOut = 10000;
        for (int i = 0; i < timeOut; i++){

            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArr(arr1);
            int[] arr3 = copyArr(arr1);


            Utils.compartor(arr1);
            sort.sort(arr2);


            if (!isEqual(arr1,arr2)){
                System.out.println("原始数组**************");
                System.out.println(Arrays.toString(arr3));
                System.out.println("fucking fuck!!!");
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                return;
            }
        }
        System.out.println("right!!!");
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
}
