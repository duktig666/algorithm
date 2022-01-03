package leetcode.tree.bst;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * description:https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @author RenShiWei
 * Date: 2022/1/3 16:52
 **/
public class 不同的二叉搜索树_95_96 {

    /** 备忘录 */
    private int[][] memo;

    /**
     * 96题
     */
    public int numTrees(int n) {
        // 备忘录的值初始化为 0
        memo = new int[n + 1][n + 1];
        // 计算闭区间 [1, n] 组成的 BST 个数
        return count(1, n);
    }

    /** 计算闭区间 [lo, hi] 组成的 BST 个数 */
    private int count(int lo, int hi) {
        // base case 空节点，也是一种情况，返回 1
        if (lo > hi) {
            return 1;
        }

        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            // i 的值作为根节点 root
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            // 左右子树的组合数乘积是 BST 的总数
            res += left * right;
        }

        // 将结果存入备忘录
        memo[lo][hi] = res;

        return res;
    }

    /**
     * 95题
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        // 构造闭区间 [1, n] 组成的 BST
        return build(1, n);
    }

    /** 构造闭区间 [lo, hi] 组成的 BST */
    private List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (lo > hi) {
            res.add(null);
            return res;
        }

        // 1、穷举 root 节点的所有可能。
        for (int i = lo; i <= hi; i++) {
            // 2、递归构造出左右子树的所有合法 BST。
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i + 1, hi);
            // 3、给 root 节点穷举所有左右子树的组合。
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }

}

