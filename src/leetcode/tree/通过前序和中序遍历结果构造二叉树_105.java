package leetcode.tree;

import common.TreeNode;

/**
 * description:https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author RenShiWei
 * Date: 2021/12/9 14:13
 **/
public class 通过前序和中序遍历结果构造二叉树_105 {

    /**
     * 主函数
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 若前序遍历数组为 preorder[preStart..preEnd]，
     * 中序遍历数组为 inorder[inStart..inEnd]，
     * 构造⼆叉树，返回该⼆叉树的根节点
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        // 递归终止条件
        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第⼀个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // 根节点左边有几个元素
        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右⼦树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

        return root;
    }

}

