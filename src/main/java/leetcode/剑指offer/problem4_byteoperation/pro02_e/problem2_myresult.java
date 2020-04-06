package leetcode.剑指offer.problem4_byteoperation.pro02_e;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/6
 * 功能描述:哈希表统计法： 遍历数组 nums ，用 HashMap 统计各数字的数量，最终超过数组长度一半的数字则为众数。此方法时间和空间复杂度均为 O(N)O(N) 。
 * 修改日期:2020/4/6
 * 修改描述:
 */
public class problem2_myresult {
}
class Solution {
    private Map<Integer,Integer> map = new HashMap<>();
    public int majorityElement(int[] nums) {
        for(int i = 0;i < nums.length; i++){
            Integer num = map.get(Integer.valueOf(nums[i]));
            if(Objects.isNull(num)){
                map.put(Integer.valueOf(nums[i]),1);
            }else{
                map.put(Integer.valueOf(nums[i]),num+1);
            }
        }
        for(Integer key : map.keySet()){
            int size = map.get(key);
            if(size >= (nums.length / 2+1)){
                return key;
            }
        }
        return 0;
    }
}
