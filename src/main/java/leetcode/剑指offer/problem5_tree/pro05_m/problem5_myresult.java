package leetcode.剑指offer.problem5_tree.pro05_m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/27
 * 功能描述:
 * 因为是按层次遍历
 * 所以按照中顺遍历将每个层次将二叉树遍历出来
 * 0--->List<Integer>
 * 1--->List<Integer>
 * 2--->List<Integer>
 * 3--->List<Integer>
 * 用level记录最高层次
 * 遍历map
 * 将所有List放在一起即可
 * 修改日期:2020/4/27
 * 修改描述:
 */
public class problem5_myresult {
}
class Solution {
    private Map<Integer, List<Integer>> map = new HashMap();
    private int level = 0;
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[]{};
        foreach(root,0);
        List<Integer> list = new ArrayList();
        for(int i = 0; i <= level;i++){
            List levelList = map.get(i);
            list.addAll(levelList);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public void foreach(TreeNode root,int i){
        if(root == null) return;
        List list = map.get(i);
        if(list == null){
            list = new ArrayList();
            list.add(root.val);
            map.put(i,list);
        }else{
            list.add(root.val);
        }
        if(level < i) level = i;
        foreach(root.left,i+1);
        foreach(root.right,i+1);
    }
}

