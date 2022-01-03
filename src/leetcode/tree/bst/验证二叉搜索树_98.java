package leetcode.tree.bst;

import common.TreeNode;

/**
 * description:https://leetcode-cn.com/problems/validate-binary-search-tree/
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * @author RenShiWei
 * Date: 2022/1/3 15:36
 **/
public class 验证二叉搜索树_98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
     */
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) {
            return true;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

}
