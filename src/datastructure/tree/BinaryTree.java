package datastructure.tree;

import java.util.*;

/**
 * description:二叉查找树实现
 *
 * @author RenShiWei
 * Date: 2021/7/8 11:40
 **/
public class BinaryTree<E extends Comparable<E>> {

    private static class TreeNode<E> {

        /** 数据域，存储数据元素 */
        public E e;
        /** 链域，分别指向左右孩子结点 */
        public TreeNode<E> left, right;

        /**
         * 构造结点，参数分别指向元素和左右孩子结点
         */
        public TreeNode(E e, TreeNode<E> left, TreeNode<E> right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        /**
         * 构造指定值的叶子结点
         */
        public TreeNode(E e) {
            this(e, null, null);
        }

        public TreeNode() {
            this(null, null, null);
        }
    }

    /** 根节点 */
    private TreeNode<E> root;
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
    public int height(TreeNode<E> p) {
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
     * @param treeNode 根节点
     * @param e        插入的元素
     * @return 返回插入新节点后二叉查找树的根
     */
    private TreeNode<E> add(TreeNode<E> treeNode, E e) {
        //当前二分搜索树为空
        if (treeNode == null) {
            size++;
            return new TreeNode<>(e);
        }
        //判断添加在左边还是右边
        if (e.compareTo(treeNode.e) < 0) {
            treeNode.left = add(treeNode.left, e);
        } else if (e.compareTo(treeNode.e) > 0) {
            treeNode.right = add(treeNode.right, e);
        }
        return treeNode;
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
     * @param treeNode 根节点
     * @param e        待查找的元素
     * @return 是否包含
     */
    private boolean contains(TreeNode<E> treeNode, E e) {
        //二叉查找树为空，肯定不包含
        if (treeNode == null) {
            return false;
        }
        if (e.compareTo(treeNode.e) == 0) {
            return true;
        } else if (e.compareTo(treeNode.e) < 0) {
            return contains(treeNode.left, e);
        } else {
            return contains(treeNode.right, e);
        }
    }

    /*
     * -----------------二叉树遍历 start---------------------
     * 前序、中序、后序 （递归和循环 两种实现方式）
     *
     * 前序遍历，出栈顺序：根左右; 入栈顺序：中-右-左
     * 中序遍历，出栈顺序：左根右; 入栈顺序：右根左
     * 后序遍历，出栈顺序：左右根; 入栈顺序：根右左
     *
     * 层序遍历： 队列
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
     * @param treeNode 根节点
     */
    private void preOrder(TreeNode<E> treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.e);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /**
     * 二叉查找树的非递归前序遍历（压栈实现）
     * 前序遍历顺序：中-左-右，入栈顺序：中-右-左
     */
    public List<Integer> preOrderByLoop(common.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<common.TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (! stack.isEmpty()) {
            common.TreeNode cur = stack.pop();
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
     * 二分搜索树的中序遍历：左->根->右
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树, 递归算法
     *
     * @param treeNode 根节点
     */
    private void inOrder(TreeNode<E> treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.println(treeNode.e);
        inOrder(treeNode.right);
    }

    /**
     * 迭代实现二叉树的中序遍历
     * 中序遍历顺序: 左-中-右 入栈顺序： 左-右
     */
    public List<Integer> inOrderLoop(common.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<common.TreeNode> stk = new LinkedList<>();
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
     * 二分搜索树的后序遍历：左->右->根
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树, 递归算法
     * 例子：内存释放，先释放孩子内存，再释放自身内存
     *
     * @param treeNode 根节点
     */
    private void postOrder(TreeNode<E> treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.e);
    }

    /**
     * 迭代实现 后序遍历
     * 与前序遍历类似，只是稍微改了顺序，并在最后翻转
     * 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
     */
    public List<Integer> postOrderLoop(common.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<common.TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (! stack.isEmpty()) {
            common.TreeNode node = stack.pop();
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

    /**
     * 前序遍历 通用框架写法
     */
    public List<Integer> preOrderCommon(common.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<common.TreeNode> stack = new LinkedList<>();
        while (root != null || ! stack.isEmpty()) {
            // 1.遍历到最左子节点
            while (root != null) {
                // 先加根
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            common.TreeNode cur = stack.pop();
            root = cur.right;

        }
        return res;
    }

    /**
     * 中序遍历 通用框架写法
     */
    public List<Integer> inOrderCommon(common.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<common.TreeNode> stack = new LinkedList<>();
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
    public List<Integer> postOrderCommon(common.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<common.TreeNode> stack = new LinkedList<>();
        while (root != null || ! stack.isEmpty()) {
            // 1.遍历到最左子节点
            while (root != null) {
                // 先加根
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }
            common.TreeNode cur = stack.pop();
            root = cur.left;

        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 二分搜索树的层序遍历
     * 应用：无权图，最短路径
     */
    public void levelOrder() {
        //链表实现队列
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()) {
            TreeNode<E> cur = queue.remove();
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
     * @param treeNode 根节点
     * @return 返回以node为根的二分搜索树的最小值所在的节点
     */
    private TreeNode<E> minimum(TreeNode<E> treeNode) {
        if (treeNode.left == null) {
            return treeNode;
        }
        return minimum(treeNode.left);
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
     * @param treeNode 根节点
     * @return 二分搜索树的最大值所在的节点
     */
    private TreeNode<E> maximum(TreeNode<E> treeNode) {
        if (treeNode.right == null) {
            return treeNode;
        }
        return maximum(treeNode.right);
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
     * @param treeNode 根节点
     * @return 返回删除节点后新的二分搜索树的根
     */
    private TreeNode<E> removeMin(TreeNode<E> treeNode) {
        if (treeNode.left == null) {
            TreeNode<E> rightTreeNode = treeNode.right;
            treeNode.right = null;
            size--;
            return rightTreeNode;
        }
        treeNode.left = removeMin(treeNode.left);
        return treeNode;
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
     * @param treeNode 根节点
     * @return 返回删除节点后新的二分搜索树的根
     */
    private TreeNode<E> removeMax(TreeNode<E> treeNode) {
        if (treeNode.right == null) {
            TreeNode<E> leftTreeNode = treeNode.left;
            treeNode.left = null;
            size--;
            return leftTreeNode;
        }
        treeNode.right = removeMax(treeNode.right);
        return treeNode;
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
     * @param treeNode 根节点
     * @param e        待删除的元素
     * @return 返回删除节点后新的二分搜索树的根
     */
    private TreeNode<E> remove(TreeNode<E> treeNode, E e) {
        if (treeNode == null) {
            return null;
        }
        if (e.compareTo(treeNode.e) < 0) {
            //小于当前节点，从左子树寻找
            treeNode.left = remove(treeNode.left, e);
            return treeNode;
        } else if (e.compareTo(treeNode.e) > 0) {
            //大于当前节点，从右子树寻找
            treeNode.right = remove(treeNode.right, e);
            return treeNode;
        } else {
            // 如果找到待删除的节点
            // 待删除节点左子树为空的情况
            if (treeNode.left == null) {
                TreeNode<E> rightTreeNode = treeNode.right;
                treeNode.right = null;
                size--;
                return rightTreeNode;
            }
            // 待删除节点右子树为空的情况
            if (treeNode.right == null) {
                TreeNode<E> leftTreeNode = treeNode.left;
                treeNode.left = null;
                size--;
                return leftTreeNode;
            }
            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            TreeNode<E> successor = minimum(treeNode.right);
            //返回值其实为node.right
            successor.right = removeMin(treeNode.right);
            successor.left = treeNode.left;
            treeNode.left = treeNode.right = null;
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
    public String toGenListString(TreeNode<E> p) {
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
     * @param treeNode 根节点
     * @param depth    从那一层开始
     * @param res      拼接的字符串
     */
    private void generateString(TreeNode<E> treeNode, int depth, StringBuilder res) {
        if (treeNode == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }
        res.append(generateDepthString(depth)).append(treeNode.e).append("\n");
        generateString(treeNode.left, depth + 1, res);
        generateString(treeNode.right, depth + 1, res);
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
    public TreeNode<E> reConstructBinaryTree(E[] preOrder, E[] inOrder) {
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
    private TreeNode<E> helper(E[] preOrder, int preL, int preR, E[] inOrder, int inL, int inR) {
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
        TreeNode<E> root = new TreeNode<>(rootVal);
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

