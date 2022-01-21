package leetcode.bfs;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @author RenShiWei
 * Date: 2022/1/21 14:49
 **/
public class 二叉树的最小深度_111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        // 最小深度 (root本身就是一层，初始化为1)
        int minDepth = 1;
        q.offer(root);

        while (! q.isEmpty()) {
            int size = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null) {
                    return minDepth;
                }
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            /* 这里增加步数 */
            minDepth++;
        }

        return minDepth;
    }

}

