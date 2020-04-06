package leetcode.剑指offer.problem3_sort.pro01_m;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/6
 * 功能描述:桶排序思想  这才是我的答案，因为这里的范围大小是不确定的，
 * 所有最后定不了桶的大小 这是有问题的。
 * 修改日期:2020/4/6
 * 修改描述:
 */
public class problem3_otherresult {
    public Map<Integer, Integer> getMap() {
        return map;
    }
    // 构建桶
    private Map<Integer,Integer> map = new LinkedHashMap();
    {
        map.put(0,0);
        map.put(100,0);
        for(int i = 1; i <= 9; i++){
            boolean iIsIn = true;
            int j = 0;
            while(j <= 9){
                if((i * 10 + j) % (i * 10) <= i) {
                    map.put(i*10+j,0);
                }else{
                    if(iIsIn){
                        map.put(i,0);
                        iIsIn = false;
                    }
                    map.put(i*10+j,0);
                }
                j++;
            }
            if(iIsIn){
                map.put(i,0);
                iIsIn = false;
            }
            iIsIn = false;
            j = 0;
        }
    }
    public static String getMinNumber(Map<Integer,Integer> map){
        StringBuilder sb = new StringBuilder();
        for(Integer i : map.keySet()){
            Integer size = map.get(i);
            if(size == 0) continue;
            while(size > 0){
                sb.append(i);
                size--;
            }
        }
        return sb.toString();
    }
}
