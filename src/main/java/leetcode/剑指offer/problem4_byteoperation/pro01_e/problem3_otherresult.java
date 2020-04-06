package leetcode.剑指offer.problem4_byteoperation.pro01_e;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/6
 * 功能描述:n & (n - 1) 可以消除 n 最后的一个1的原理 简化操作
 * 修改日期:2020/4/6
 * 修改描述:
 */
public class problem3_otherresult {
}
class Solution1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
