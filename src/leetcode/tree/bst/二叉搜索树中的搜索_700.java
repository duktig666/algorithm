package leetcode.tree.bst;

import common.TreeNode;

/**
 * description:https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * @author RenShiWei
 * Date: 2022/1/3 15:44
 **/
public class 二叉搜索树中的搜索_700 {

    /**
     * 不同于 普通二叉树的搜索
     * 每次只用遍历一边即可
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        // 去左子树搜索
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        // 去右子树搜索
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return root;
    }

    /**
     * 二叉树的搜索
     */
    TreeNode searchTree(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        // 当前节点没找到就递归地去左右子树寻找
        TreeNode left = searchBST(root.left, target);
        TreeNode right = searchBST(root.right, target);

        return left != null ? left : right;
    }

}

