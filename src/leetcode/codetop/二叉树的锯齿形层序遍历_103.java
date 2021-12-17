package leetcode.codetop;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description:https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * <p>
 * 二叉树层序遍历的变种
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
 *
 * @author RenShiWei
 * Date: 2021/12/17 9:36
 **/
public class 二叉树的锯齿形层序遍历_103 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        // 树为空，直接返回
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isAddLeft = true;

        while (! queue.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            int curSize = queue.size();

            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();
                assert curNode != null;
                if (isAddLeft) {
                    list.offerLast(curNode.val);
                } else {
                    list.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(new LinkedList<>(list));
            isAddLeft = ! isAddLeft;
        }
        return res;
    }

}

