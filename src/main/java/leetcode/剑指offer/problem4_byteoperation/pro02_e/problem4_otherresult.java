package leetcode.剑指offer.problem4_byteoperation.pro02_e;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/6
 * 功能描述:
 * 摩尔投票法： 核心理念为 “正负抵消” ；
 * 时间和空间复杂度分别为 O(N)O(N) 和 O(1)O(1) ；是本题的最佳解法。
 * 修改日期:2020/4/6
 * 修改描述:
 */
public class problem4_otherresult {
}
class Solution3 {
    public int majorityElement(int[] nums) {
        int result = 0;
        int vote = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == result){
                vote++;
            }else{
                vote--;
            }
            if(vote < 0){
                result = nums[i];
                vote = 1;
            }
        }
        return result;
    }
}
