package leetcode.剑指offer.problem5_tree.pro07_m;

import java.util.*;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/28
 * 功能描述:
 * 修改日期:2020/4/28
 * 修改描述:
 */
public class problem7_otherresult {
}
class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        LinkedList<TreeNode> linkedList = new LinkedList();
        ArrayList<List<Integer>> arrayList = new ArrayList();
        linkedList.add(root);
        while(!linkedList.isEmpty()) {
            LinkedList<Integer> list = new LinkedList();
            for(int i = linkedList.size();i > 0; i--){
                TreeNode node = linkedList.poll();
                if((arrayList.size() & 2) == 1) list.addFirst(node.val);
                else list.addLast(node.val);
                list.add(node.val);
                if(node.left != null) linkedList.add(node.left);
                if(node.right != null) linkedList.add(node.right);
            }
            arrayList.add(list);
        }
        return arrayList;
    }
}