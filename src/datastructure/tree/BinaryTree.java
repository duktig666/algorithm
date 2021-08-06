package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * description:二叉查找树实现
 *
 * @author RenShiWei
 * Date: 2021/7/8 11:40
 **/
public class BinaryTree<E extends Comparable<E>> {

    private static class Node<E> {

        /** 数据域，存储数据元素 */
        public E e;
        /** 链域，分别指向左右孩子结点 */
        public Node<E> left, right;

        /**
         * 构造结点，参数分别指向元素和左右孩子结点
         */
        public Node(E e, Node<E> left, Node<E> right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        /**
         * 构造指定值的叶子结点
         */
        public Node(E e) {
            this(e, null, null);
        }

        public Node() {
            this(null, null, null);
        }
    }

    /** 根节点 */
    private Node<E> root;
    /** 树的节点个数 */
    private int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    /**
     * @return 元素个数
     */
    public int size() {
        return size;
    }

    /**
     * @return 是否为空树
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return 返回二叉树的高度
     */
    public int height() {
        return height(root);
    }

    /**
     * @param p 根节点
     * @return 二叉树的高度
     */
    public int height(Node<E> p) {
        if (p == null) {
            return 0;
        }
        // 返回左子树的高度
        int lh = height(p.left);
        // 返回右子树的高度
        int rh = height(p.right);
        // 当前子树高度为较高子树的高度加1（+根结点高度）
        return lh >= rh ? lh + 1 : rh + 1;
    }

    /**
     * 添加元素
     *
     * @param e 待添加元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的二叉查找树中插入元素e，递归算法
     *
     * @param node 根节点
     * @param e    插入的元素
     * @return 返回插入新节点后二叉查找树的根
     */
    private Node<E> add(Node<E> node, E e) {
        //当前二分搜索树为空
        if (node == null) {
            size++;
            return new Node<>(e);
        }
        //判断添加在左边还是右边
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 看二叉查找树中是否包含元素e
     *
     * @param e 待查找的元素
     * @return 是否包含
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二叉查找树中是否包含元素e, 递归算法
     *
     * @param node 根节点
     * @param e    待查找的元素
     * @return 是否包含
     */
    private boolean contains(Node<E> node, E e) {
        //二叉查找树为空，肯定不包含
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /*
     * -----------------二叉树遍历 start---------------------
     * 前序、中序、后序 （递归和循环 两种实现方式）
     * 层次
     */

    /**
     * 二叉查找树的前序遍历：根->左->右
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二叉查找树, 递归算法
     *
     * @param node 根节点
     */
    private void preOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二叉查找树的非递归前序遍历（压栈实现）
     */
    public void preOrderByLoop() {
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        while (! stack.isEmpty()) {
            Node<E> cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二分搜索树的中序遍历：左->根->右
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树, 递归算法
     *
     * @param node 根节点
     */
    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历：左->右->根
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树, 递归算法
     * 例子：内存释放，先释放孩子内存，再释放自身内存
     *
     * @param node 根节点
     */
    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 二分搜索树的层序遍历
     * 应用：无权图，最短路径
     */
    public void levelOrder() {
        //链表实现队列
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()) {
            Node<E> cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    //-----------------二叉树遍历 end---------------------

    /*
        ------------二叉树寻找最大值、最小值 start----------
     */

    /**
     * 寻找二分搜索树的最小元素
     *
     * @return 最小元素
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return minimum(root).e;
    }

    /**
     * 查找二叉树最小值所在的节点
     *
     * @param node 根节点
     * @return 返回以node为根的二分搜索树的最小值所在的节点
     */
    private Node<E> minimum(Node<E> node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return 最大元素
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    /**
     * 查找二分搜索树的最大值所在的节点
     *
     * @param node 根节点
     * @return 二分搜索树的最大值所在的节点
     */
    private Node<E> maximum(Node<E> node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    //------------二叉树寻找最大值、最小值 start----------

    /**
     * 从二分搜索树中 删除最小值所在节点
     *
     * @return 最小值
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     *
     * @param node 根节点
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node<E> removeMin(Node<E> node) {
        if (node.left == null) {
            Node<E> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     *
     * @return 返回最大值
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     *
     * @param node 根节点
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node<E> removeMax(Node<E> node) {
        if (node.right == null) {
            Node<E> leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     *
     * @param e 待删除的元素
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
     *
     * @param node 根节点
     * @param e    待删除的元素
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node<E> remove(Node<E> node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            //小于当前节点，从左子树寻找
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            //大于当前节点，从右子树寻找
            node.right = remove(node.right, e);
            return node;
        } else {
            // 如果找到待删除的节点
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node<E> rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node<E> leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node<E> successor = minimum(node.right);
            //返回值其实为node.right
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    public void removeAll(E e) {
        this.root = null;
    }

    /**
     * 返回
     *
     * @return 二叉树的广义表表示字符串
     */
    public String toGenListString() {
        return "二叉树的广义表表示:" + toGenListString(this.root) + "\n";
    }

    /**
     * @param p 根节点
     * @return 二叉树的广义表表示字符串
     */
    public String toGenListString(Node<E> p) {
        if (p == null) {
            // 返回空子树表示
            return "^";
        }
        String str = p.e.toString();
        // 非叶结点，有子树
        if (p.left != null || p.right != null) {
            // 递归调用
            str += "(" + toGenListString(p.left) + ","
                    + toGenListString(p.right) + ")";
        }
        return str;
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     *
     * @param node  根节点
     * @param depth 从那一层开始
     * @param res   拼接的字符串
     */
    private void generateString(Node<E> node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }
        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    /**
     * 打印其深度--
     *
     * @param depth 深度
     * @return 本层的所有元素字符串
     */
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    /**
     * 这种方式描述树，不如广义表描述的直观
     * StringBuilder res = new StringBuilder();
     * generateString(root, 0, res);
     * return res.toString();
     */
    @Override
    public String toString() {
        return toGenListString();
    }

    /*
        -----------------------   重建二叉树 开始  -------------------------
        根据前序遍历和中序遍历，构建二叉树
     */

    /**
     * 解法：重建二叉树
     * 递归：传入子数组的边界索引
     * 时间复杂度：O(n)，空间复杂度：O(n)
     *
     * @param preOrder 前序遍历序列
     * @param inOrder  中序遍历序列
     * @return 树根节点
     */
    public Node<E> reConstructBinaryTree(E[] preOrder, E[] inOrder) {
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
    private Node<E> helper(E[] preOrder, int preL, int preR, E[] inOrder, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        //根节点的值
        E rootVal = preOrder[preL];
        //计算 中序序列中根节点的索引（左子树的节点数量）
        int index = 0;
        while (index <= inR && inOrder[index] != rootVal) {
            index++;
        }
        Node<E> root = new Node<>(rootVal);
        //选取前序序列和中序序列中左子树的子序列，递归构建左子树
        root.left = helper(preOrder, preL + 1, preL - inL + index, inOrder, inL, index);
        //选取前序序列和中序序列中右子树的子序列，递归构建右子树
        root.right = helper(preOrder, preL - inL + index + 1, preR, inOrder, index + 1, inR);
        //返回二叉树的根结点
        return root;
    }

    //-----------------------   重建二叉树 结束  -------------------------

    /**
     * 测试
     */
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(1);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        System.out.println(tree);
        System.out.println("树的高度：" + tree.height());
        System.out.println("--先序遍历--");
        tree.preOrder();
        System.out.println("--中序遍历--");
        tree.inOrder();
        System.out.println("--后序遍历--");
        tree.postOrder();
        System.out.println("--随机测试--");
        System.out.println(tree.toGenListString());

        System.out.println("--重建二叉树--");
        // 前序遍历结果
        Integer[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        // 中序遍历结果
        Integer[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree<Integer> reConstructBinaryTree = new BinaryTree<>();
        reConstructBinaryTree.root = reConstructBinaryTree.reConstructBinaryTree(pre, in);
        System.out.println(reConstructBinaryTree);
    }

}

