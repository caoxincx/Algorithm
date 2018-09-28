package sort.merge;

/**
 * @描述
 * @创建人 caoxin
 * @创建时间 2018/9/26
 * @修改人和其它信息
 */

/**
 * 1.卡住返回值
 */
public class Division {
    public static int divide(int left,int right){
        if ( left == right){
            return left;
        }
        int middle = (left+right)>> 1;
        int onLeft = divide(left, middle);
        int onRight = divide(middle + 1, right);

        System.out.println("**********************");
        while(onLeft <= middle && onRight <= right){

        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,8,9,7,5};
        divide(0,arr.length-1);
    }
}
