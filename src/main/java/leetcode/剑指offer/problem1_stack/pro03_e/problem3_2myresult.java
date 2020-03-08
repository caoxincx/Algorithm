package leetcode.剑指offer.problem1_stack.pro03_e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/3/8
 * 功能描述:
 * 修改日期:2020/3/8
 * 修改描述:
 */
public class problem3_2myresult {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arrs = {1,3,-1,-3,5,3,6,7};
        int[] ints = solution.maxSlidingWindow(arrs, 3);
        System.out.println(Arrays.toString(ints));
    }
}
class Solution {
    private Stack<Integer> stack = new Stack();
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] slideNums = new int[nums.length + 1 -k];
        if(k <= 0){
            return null;
        }
        if(k<1 || k>nums.length){
            return null;
        }
        int j=0,tempi=0;
        for(int i = 0; tempi < nums.length+1 -k; i++){
            if((j ^ k) == 0){
                if(!stack.isEmpty()){
                    slideNums[tempi] = stack.stream().max(Integer::compareTo).get();
                    stack.clear();
                }
                i = tempi++;
                j = 0;
                continue;
            }
            j++;
            stack.push(nums[i]);
        }
        return slideNums;
    }
}