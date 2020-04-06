package leetcode.剑指offer.problem4_byteoperation.pro02_e;

import java.util.Arrays;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/6
 * 功能描述:数组排序法： 将数组 nums 排序，由于众数的数量超过数组长度一半，
 * 因此 数组中点的元素 一定为众数。此方法时间复杂度 O(N log_2 N)O(NlogN)
 * 修改日期:2020/4/6
 * 修改描述:
 */
public class problem3_otherresult {
}
class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
