package leetcode.codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description:https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author RenShiWei
 * Date: 2021/12/14 21:17
 **/
public class 二叉树的层序遍历_102 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 二叉树 遍历思路：
     * 1. 迭代遍历，需要借助数据结构
     * 1.1 层序遍历需要借助 队列
     * 1.2 前、中、后序遍历借助 栈
     * <p>
     * 2. 为什么层序遍历要借助 队列 来实现？
     * 2.1 遍历前，先处理根节点
     * 2.2 遍历时，每次将左右孩子加入队列，这样就可以构成每次将左右孩子层层向下 在队列中排队
     * <p>
     * 3. 为什么前、中、后序遍历借助 栈？
     * 3.1 遍历前，先处理根节点
     * 3.2 遍历时，每次将左右孩子加入栈（注意加入栈的时机）
     * 3.3 每次都先加入一个序列，然后出栈一个，其他序列一直压在栈中
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 记录结果
        List<List<Integer>> res = new ArrayList<>();
        // 树为空，直接返回
        if (root == null) {
            return res;
        }
        // 利用队列，完成层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 先加入根节点
        queue.offer(root);
        while (! queue.isEmpty()) {
            // 记录当前层级元素的集合
            List<Integer> tempList = new ArrayList<>();
            // 当前层级队列中的元素个数
            int currentLevelSize = queue.size();
            // 依次将当前层级的左右孩子，加入到队列中
            for (int i = 1; i <= currentLevelSize; ++ i) {
                TreeNode curNode = queue.poll();
                tempList.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }

                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(tempList);
        }
        return res;
    }


}

