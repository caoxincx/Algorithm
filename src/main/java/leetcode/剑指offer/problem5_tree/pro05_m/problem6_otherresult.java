package leetcode.剑指offer.problem5_tree.pro05_m;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/27
 * 功能描述:
 * 修改日期:2020/4/27
 * 修改描述:
 */
public class problem6_otherresult {
}
class Solution1 {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[]{};
        LinkedList<TreeNode> list = new LinkedList();
        List<Integer> array = new ArrayList();
        list.add(root);

        while(!list.isEmpty()){
            TreeNode node = list.poll();
            array.add(node.val);
            if(node.left != null) list.add(node.left);
            if(node.right != null) list.add(node.right);
        }
        return array.stream().mapToInt(Integer::intValue).toArray();
    }
}
