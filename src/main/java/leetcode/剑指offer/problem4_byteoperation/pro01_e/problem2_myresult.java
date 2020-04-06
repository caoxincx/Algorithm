package leetcode.剑指offer.problem4_byteoperation.pro01_e;

import java.util.stream.Stream;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/6
 * 功能描述:
 * 修改日期:2020/4/6
 * 修改描述:
 */
public class problem2_myresult {
}
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return (int)Stream.of(Integer.toBinaryString(n)).
                flatMap(line -> Stream.of(line.split(""))).
                filter(i -> "1".equals(i)).
                count();
    }
}
