package leetcode.tree;

/**
 * description:https://leetcode-cn.com/problems/maximum-binary-tree/
 *
 * @author RenShiWei
 * Date: 2021/12/9 11:13
 **/
public class 最大二叉树_654 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 主函数
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /**
     * 将 nums[low..high] 构造成符合条件的树，返回根节点
     *
     * @param nums 待构建二叉树的数组
     * @param low  子树的左端数组下标
     * @param high 子树的右端数组下标
     * @return 构造好子树的根节点
     */
    private TreeNode build(int[] nums, int low, int high) {
        // 递归的终止条件
        if (low > high) {
            return null;
        }

        // 找到数组中的最大值和对应的索引
        int index = - 1, maxVal = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
                index = i;
            }
        }

        // 最大值构建根节点
        TreeNode root = new TreeNode(maxVal);
        // 递归构建左右子树
        root.left = build(nums, low, index - 1);
        root.right = build(nums, index + 1, high);

        return root;
    }


}

