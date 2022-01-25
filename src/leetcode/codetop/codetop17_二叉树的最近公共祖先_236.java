package leetcode.codetop;

/**
 * description:https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author RenShiWei
 * Date: 2021/12/20 9:26
 **/
public class codetop17_二叉树的最近公共祖先_236 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    /**
     * 寻找二叉树的公共祖先（递归）
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) {
            return null;
        }
        // 如果 root 是p 或者 q 返回当前节点（在后序遍历中可能是 left 或 right）
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况1：如果p和q都在以root为根的树中，那么left和right一定分别是p和q
        if (left != null && right != null) {
            return root;
        }
        // 情况2：如果p和q都不在以root为根的树中，直接返回null
        if (left == null && right == null) {
            return null;
        }
        // 情况3：如果p和q只有一个存在于root为根的树中，函数返回该节点
        return left == null ? right : left;
    }


}

