package leetcode.tree.bst;

import common.TreeNode;

/**
 * description: https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * @author RenShiWei
 * Date: 2022/1/3 16:12
 **/
public class 删除二叉搜索树中的节点_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        // base case
        if (root == null) {
            return null;
        }
        // 找到待删除的元素节点
        if (root.val == key) {
            // 这两个 if 把情况 1 和 2 都正确处理了
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 处理情况 3
            // 获得右子树最小的节点
            TreeNode minNode = getMin(root.right);
            // 删除右子树最小的节点
            root.right = deleteNode(root.right, minNode.val);
            // 用右子树最小的节点替换 root 节点
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    /**
     * 在二叉搜索树中寻找最小节点
     */
    private TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}

