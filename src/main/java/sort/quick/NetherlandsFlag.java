package sort.quick;

import com.sun.corba.se.impl.logging.UtilSystemException;
import sort.SortUtils.Utils;

import java.util.Arrays;

/**
 * @描述 荷兰过期问题，将一个数组分成大于等于区间，等于区间和小于等于区间
 * @创建人 caoxin
 * @创建时间 2018/9/29
 * @修改人和其它信息
 */
public class NetherlandsFlag {
    public static int[] netherlandsFlag(int[] arr,int left, int right,int comparator){
        //1.小于等于区指针
        int smallZone = left - 1;
        //2.大于等于区指针
        int bigZone = right + 1;

        //3.left作为移动数组的index指针,保证【left指针小于 【大于等于区】】
        while(left < bigZone){
            if (arr[left] < comparator){
                //1.如果当前的值小于 【比较值】，小于等于区加1，指针向右移动，【小于等于区的数一定 小于等于compartor】
                //所以作为index指针的left向左移动
                Utils.swap(arr,left++,++smallZone);
            }else if (arr[left] > comparator){
                //2.从【大于等于区】交换的值不确定大小，所以需要重新对应
                //所以作为index的left指针不向左移动
                Utils.swap(arr,left,--bigZone);
            }else {
                //3.相等的情况作为index的left指针向左移动
                left++;
            }
        }
        System.out.println("smallZone:"+(smallZone+1));
        System.out.println("bigZone:"+bigZone);
        return new int[]{smallZone+1,bigZone};
    }

    public static void main(String[] args) {
        int[] arr = {1,4,8,9,7,5};
        netherlandsFlag(arr,0,arr.length-1,6);
        System.out.println(Arrays.toString(arr));
    }
}
