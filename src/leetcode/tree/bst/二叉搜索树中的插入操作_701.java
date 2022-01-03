package leetcode.tree.bst;

import common.TreeNode;

/**
 * description: https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * <p>
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * @author RenShiWei
 * Date: 2022/1/3 15:57
 **/
public class 二叉搜索树中的插入操作_701 {

    /**
     * 在 BST 中插入一个元素
     * 先找到插入的位置，然后插入元素即可
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) {
            return new TreeNode(val);
        }
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

}

