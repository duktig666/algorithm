package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * description:https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * <p>
 * 针对于二叉树写出其 前序、中序（只能完成序列化，不能实现反序列化）、后序、层序遍历 序列化和反序列化
 *
 * @author RenShiWei
 * Date: 2021/12/16 11:03
 **/
public class 二叉树的序列化与反序列化_297 {

    /**
     * 前序遍历
     */
    public static class preOrder {

        /** 元素分隔符 */
        final String SEP = ",";
        /** 空节点 */
        final String NULL = "#";

        /** 主函数，将二叉树序列化为字符串 */
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        /** 辅助函数，将二叉树存入 StringBuilder */
        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            /* 前序遍历位置 */
            sb.append(root.val).append(SEP);

            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        /* 主函数，将字符串反序列化为二叉树结构 */
        public TreeNode deserialize(String data) {
            // 将字符串转化成列表
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : data.split(SEP)) {
                nodes.addLast(s);
            }
            return deserialize(nodes);
        }

        /* 辅助函数，通过 nodes 列表构造二叉树 */
        private TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }

            /* 前序遍历位置 */
            // 列表最左侧就是根节点
            String first = nodes.removeFirst();
            if (first.equals(NULL)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(first));

            root.left = deserialize(nodes);
            root.right = deserialize(nodes);

            return root;
        }

    }


    /**
     * 后序遍历
     */
    public static class postOrder {

        /** 元素分隔符 */
        final String SEP = ",";
        /** 空节点 */
        final String NULL = "#";

        /** 主函数，将二叉树序列化为字符串 */
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        /** 辅助函数，将二叉树存入 StringBuilder */
        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            serialize(root.left, sb);
            serialize(root.right, sb);

            /* 后序遍历位置 */
            sb.append(root.val).append(SEP);
        }

        /** 主函数，将字符串反序列化为二叉树结构 */
        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : data.split(SEP)) {
                nodes.addLast(s);
            }
            return deserialize(nodes);
        }

        /** 辅助函数，通过 nodes 列表构造二叉树 */
        private TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }
            // 从后往前取出元素
            String last = nodes.removeLast();
            if (last.equals(NULL)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(last));
            // 先构造右子树，后构造左子树
            root.right = deserialize(nodes);
            root.left = deserialize(nodes);

            return root;
        }

    }


    /**
     * 层序遍历
     */
    public static class levelOrder {

        /** 元素分隔符 */
        final String SEP = ",";
        /** 空节点 */
        final String NULL = "#";


        /* 将二叉树序列化为字符串 */
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            // 初始化队列，将 root 加入队列
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (! q.isEmpty()) {
                TreeNode cur = q.poll();

                /* 层级遍历代码位置 */
                if (cur == null) {
                    sb.append(NULL).append(SEP);
                    continue;
                }
                sb.append(cur.val).append(SEP);

                q.offer(cur.left);
                q.offer(cur.right);
            }

            return sb.toString();
        }

        /* 将字符串反序列化为二叉树结构 */
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] nodes = data.split(SEP);
            // 第一个元素就是 root 的值
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

            // 队列 q 记录父节点，将 root 加入队列
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            for (int i = 1; i < nodes.length; ) {
                // 队列中存的都是父节点
                TreeNode parent = q.poll();
                // 父节点对应的左侧子节点的值
                String left = nodes[i++];
                if (! left.equals(NULL)) {
                    Objects.requireNonNull(parent).left = new TreeNode(Integer.parseInt(left));
                    q.offer(parent.left);
                } else {
                    Objects.requireNonNull(parent).left = null;
                }
                // 父节点对应的右侧子节点的值
                String right = nodes[i++];
                if (! right.equals(NULL)) {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    q.offer(parent.right);
                } else {
                    parent.right = null;
                }
            }
            return root;
        }

    }

}

