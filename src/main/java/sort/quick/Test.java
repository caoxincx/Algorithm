package sort.quick;


import sort.SortUtils.Utils;

/**
 * @描述 手撸快速排序
 * @创建人 caoxin
 * @创建时间 2018/9/29
 * @修改人和其它信息
 */
public class Test {
    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right){
            int comparator = Utils.getComparator(arr, left, right);
            int[] partition = partition(arr,left,right,comparator);

            //1.左边排序
            quickSort(arr,left,partition[0]);
            //2.右边排序
            quickSort(arr,partition[1],right);
        }
    }

    private static int[] partition(int[] arr, int left, int right,int comparator) {
        int smallZone = left - 1;
        int bigZone = right + 1;
        while(left < bigZone){
            if (arr[left] < comparator){
                Utils.swap(arr,++smallZone,left++);
            }else if (arr[left] > comparator){
                Utils.swap(arr,--bigZone,left);
            }else {
                left++;
            }
        }
        return new int[]{smallZone,bigZone};
    }


    public static void main(String[] args) {
        Utils.testSortTemplate(new sort.merge.Test());
    }
}
