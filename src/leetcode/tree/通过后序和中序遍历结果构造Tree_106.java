package leetcode.tree;

import common.TreeNode;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/12/9 14:36
 **/
public class 通过后序和中序遍历结果构造Tree_106 {

    /**
     * 主函数
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    /**
     * 中序遍历数组为 inorder[inStart..inEnd]，
     * 后序遍历数组为 postorder[postStart..postEnd]，
     * 构造⼆叉树，返回该⼆叉树的根节点
     */
    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {
        // 递归终止条件
        if (inStart > inEnd) {
            return null;
        }

        // root 节点对应的值就是后序遍历数组的最后⼀个元素
        int rootVal = postorder[postEnd];

        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // 左⼦树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右⼦树
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);

        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

}

