package leetcode.codetop;

import common.TreeNode;

/**
 * description: https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * @author RenShiWei
 * Date: 2022/2/10 9:36
 **/
public class codetop36_二叉树中的最大路径和_124 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算单边路径和时顺便计算最大路径和
        oneSideMax(root);
        return res;
    }

    /**
     * 定义：计算从根节点 root 为起点的最大单边路径和
     */
    private int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxSum = Math.max(0, oneSideMax(root.left));
        int rightMaxSum = Math.max(0, oneSideMax(root.right));
        // 后序遍历位置，顺便更新最大路径和
        int pathMaxSum = root.val + leftMaxSum + rightMaxSum;
        res = Math.max(res, pathMaxSum);
        // 实现函数定义，左右子树的最大单边路径和加上根节点的值
        // 就是从根节点 root 为起点的最大单边路径和
        return Math.max(leftMaxSum, rightMaxSum) + root.val;
    }

}

