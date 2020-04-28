package leetcode.剑指offer.problem5_tree.pro07_m;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/4/28
 * 功能描述:该题与problem05一致不再累赘
 * 修改日期:2020/4/28
 * 修改描述:
 */
public class problem7_myresult {
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        LinkedList<TreeNode> linkedList = new LinkedList();
        ArrayList<List<Integer>> arrayList = new ArrayList();
        linkedList.add(root);
        int j = 1;
        while(!linkedList.isEmpty()) {
            List<Integer> list = new ArrayList();
            for(int i = linkedList.size();i > 0; i--){
                TreeNode node = linkedList.poll();
                list.add(node.val);
                if(node.left != null) linkedList.add(node.left);
                if(node.right != null) linkedList.add(node.right);
            }
            arrayList.add(list);
            if(j % 2 == 0) Collections.reverse(list);
            j++;
        }
        return arrayList;
    }
}
