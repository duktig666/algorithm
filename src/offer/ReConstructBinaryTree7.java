package offer;

/**
 * description:《剑指offer》第七题——重建二叉树
 *
 * @author RenShiWei
 * Date: 2021/8/6 14:02
 **/
public class ReConstructBinaryTree7 {

    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 解法：重建二叉树
     * 递归：传入子数组的边界索引
     * 时间复杂度：O(n)，空间复杂度：O(n)
     *
     * @param preOrder 前序遍历序列
     * @param inOrder  中序遍历序列
     * @return 树根节点
     */
    public static TreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length == 0 || inOrder == null || inOrder.length == 0) {
            return null;
        }
        return helper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    /**
     * @param preOrder 先序遍历序列
     * @param preL     子 先序遍历序列开始索引
     * @param preR     子 先序遍历序列结束索引
     * @param inOrder  中序遍历序列
     * @param inL      子 中序遍历序列开始索引
     * @param inR      子 中序遍历序列结束索引
     * @return 树根节点
     */
    private static TreeNode helper(int[] preOrder, int preL, int preR, int[] inOrder, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        //根节点的值
        int rootVal = preOrder[preL];
        //计算 中序序列中根节点的索引（左子树的节点数量）
        int index = 0;
        while (index <= inR && inOrder[index] != rootVal) {
            index++;
        }
        TreeNode root = new TreeNode(rootVal);
        //选取前序序列和中序序列中左子树的子序列，递归构建左子树
        root.left = helper(preOrder, preL + 1, preL - inL + index, inOrder, inL, index);
        //选取前序序列和中序序列中右子树的子序列，递归构建右子树
        root.right = helper(preOrder, preL - inL + index + 1, preR, inOrder, index + 1, inR);
        //返回二叉树的根结点
        return root;
    }

    /**
     * 二叉树的广义表输出
     *
     * @param p 根结点
     * @return 二叉树的广义表Str
     */
    private static String toGenListString(TreeNode p) {
        if (p == null) {
            // 返回空子树表示
            return "^";
        }
        String str = Integer.toString(p.val);
        // 非叶结点，有子树
        if (p.left != null || p.right != null) {
            // 递归调用
            str += "(" + toGenListString(p.left) + ","
                    + toGenListString(p.right) + ")";
        }
        return str;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        // 前序遍历结果
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        // 中序遍历结果
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = ReConstructBinaryTree7.reConstructBinaryTree(pre, in);
        System.out.print("重建后的二叉树（层序输出）：" + toGenListString(root));
    }

}

