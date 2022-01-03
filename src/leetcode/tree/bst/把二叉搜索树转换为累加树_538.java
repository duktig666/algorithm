package leetcode.tree.bst;

import common.TreeNode;

/**
 * description:https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * <p>
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * @author RenShiWei
 * Date: 2022/1/3 15:15
 **/
public class 把二叉搜索树转换为累加树_538 {

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    /** 记录累加和 */
    int sum = 0;

    /**
     * 中序遍历
     * 先执行 right，再执行 left，逆序遍历
     * 计算逆序和，并赋值
     */
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        // 维护累加和
        sum += root.val;
        // 将 BST 转化成累加树
        root.val = sum;
        traverse(root.left);
    }

}

