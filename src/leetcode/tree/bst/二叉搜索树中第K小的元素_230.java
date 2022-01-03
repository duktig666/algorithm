package leetcode.tree.bst;

import common.TreeNode;

/**
 * description:https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 *
 * @author RenShiWei
 * Date: 2022/1/3 14:44
 **/
public class 二叉搜索树中第K小的元素_230 {

    /** 记录结果 */
    int res = 0;
    /** 记录当前元素的排名 */
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    /**
     * 中序遍历 寻找第 K 小的元素
     */
    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

}

