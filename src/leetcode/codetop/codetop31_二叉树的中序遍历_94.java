package leetcode.codetop;

import common.TreeNode;

import java.util.*;

/**
 * description: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author RenShiWei
 * Date: 2022/1/26 11:08
 **/
public class codetop31_二叉树的中序遍历_94 {

    List<Integer> res = new ArrayList<>();

    /**
     * 递归实现二叉树的中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    /**
     * 迭代实现二叉树的中序遍历
     * <p>
     * 中序遍历顺序: 左-中-右 入栈顺序： 左-右
     */
    public List<Integer> inorderTraversalLoop(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        // root为空 或者 stack为空，遍历结束
        while (root != null || ! stk.isEmpty()) {
            // 先根后左入栈，访问到最底层
            if (root != null) {
                // 将访问的节点放进栈
                stk.push(root);
                // 左
                root = root.left;
            } else {
                /*
                    此时root==null，说明上一步的root没有左子树
                    1. 执行左出栈。因为此时root==null，导致root.right一定为null
                    2. 执行下一次外层while代码块，根出栈。此时root.right可能存在
                    3a. 若root.right存在，右入栈，再出栈
                    3b. 若root.right不存在，重复步骤2
                */
                // 从栈里弹出的数据，就是要处理的数据（放进result数组里的数据）
                root = stk.pop();
                // 中
                res.add(root.val);
                // 右
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 迭代实现
     * 前序遍历顺序：中-左-右，入栈顺序：中-右-左
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (! stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }

    /**
     * 迭代实现 后序遍历
     * 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (! stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || ! stack.isEmpty()) {
            // 1.遍历到最左子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 2.遍历最左子节点的右子树(右子树存在 && 未访问过)
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                // 避免重复访问右子树[记录当前节点便于下一步对比]
                prev = root;
                // 避免重复访问左子树[设空节点]
                root = null;
            } else {
                // 重复压栈以记录当前路径分叉节点
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 前序遍历 通用框架写法
     */
    public List<Integer> preOrderCommon(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || ! stack.isEmpty()) {
            // 1.遍历到最左子节点
            while (root != null) {
                // 先加根
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            root = cur.right;

        }
        return res;
    }

    /**
     * 中序遍历 通用框架写法
     */
    public List<Integer> inOrderCommon(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        // root为空 或者 stack为空，遍历结束
        while (root != null || ! stack.isEmpty()) {
            // 先根后左入栈，访问到最底层
            if (root != null) {
                // 将访问的节点放进栈
                stack.push(root);
                // 左
                root = root.left;
            } else {
                /*
                    此时root==null，说明上一步的root没有左子树
                    1. 执行左出栈。因为此时root==null，导致root.right一定为null
                    2. 执行下一次外层while代码块，根出栈。此时root.right可能存在
                    3a. 若root.right存在，右入栈，再出栈
                    3b. 若root.right不存在，重复步骤2
                */
                // 从栈里弹出的数据，就是要处理的数据（放进result数组里的数据）
                root = stack.pop();
                // 中
                res.add(root.val);
                // 右
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 后序遍历 通用框架写法
     */
    public List<Integer> postOrderCommon(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || ! stack.isEmpty()) {
            // 1.遍历到最左子节点
            while (root != null) {
                // 先加根
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }
            TreeNode cur = stack.pop();
            root = cur.left;

        }
        Collections.reverse(res);
        return res;
    }


}

