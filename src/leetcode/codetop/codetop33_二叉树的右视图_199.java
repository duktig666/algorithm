package leetcode.codetop;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description: https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * @author RenShiWei
 * Date: 2022/2/7 16:54
 **/
public class codetop33_二叉树的右视图_199 {

    List<Integer> res = new ArrayList<>();

    /** 记录递归的层数 */
    int depth = 0;

    /**
     * DFS 解题
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return res;
        }
        // 前序遍历位置
        depth++;

        if (res.size() < depth) {
            // 这一层还没有记录值，说明 root 就是右侧视图的第一个节点
            res.add(root.val);
        }

        // 注意，这里反过来，先遍历右子树再遍历左子树;这样首先遍历的一定是右侧节点
        rightSideView(root.right);
        rightSideView(root.left);

        // 后序遍历位置
        depth--;

        return res;
    }

    /**
     * BFS 解题
     */
    public List<Integer> rightSideViewBFS(TreeNode root) {
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (! q.isEmpty()) {
            int size = q.size();
            // 每一层队列中第一个元素就是 最右边的一个元素
            TreeNode last = q.peek();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
            }
            res.add(last.val);
        }

        return res;
    }

}

