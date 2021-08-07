package offer;

/**
 * description:二叉树的下一个节点（中序遍历）
 * <p>
 * 情况分析：
 * 1. 如果一个节点的右子树不为空（有右子树），那么该节点的下一个节点是右子树的最左节点<br>
 * 2. 如果一个节点的右子树为空（无右子树）<br>
 * ① 当前节点是父节点的左子节点，那么下一个节点是其父节点<br>
 * ② 当前节点是父节点的右子节点，那么下一个节点需要沿父节点向上遍历，直到找到一个是它父节点的左子节点的节点（可能存在没有下一个节点，即最右节点）<br>
 * 这两种情况其实可以总结为<br>
 * 如果一个节点的右子树为空，那么需要沿着父节点的指针一直向上遍历，知道找到一个是它父节点的左子节点的节点。
 * 如果这样的节点存在，那么这个节点的父节点就是我们要找的下一个节点。
 *
 * @author RenShiWei
 * Date: 2021/8/7 9:15
 **/
public class InOrderNextTreeNode8<T> {

    private static class TreeNode<T> {
        T val;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode<T> parent;

        TreeNode(T val) {
            this.val = val;
        }
    }

    /**
     * 寻找二叉树的下一个节点（中序遍历）
     *
     * @param pNode 当前二叉树节点
     * @return 下一个节点
     */
    public TreeNode<T> getNext(TreeNode<T> pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            //有右子树
            TreeNode<T> rNode = pNode.right;
            //找右子树的最左节点
            while (rNode.left != null) {
                rNode = rNode.left;
            }
            return rNode;
        } else {
            /*
              当前节点无右子树，分两种情况
              情况1：当前节点是父节点的左子节点，那么下一个节点是其父节点
              if (pNode == pNode.parent.left) {
                return pNode.parent;
              }
              可以总体整合如下技术：
             */
            while (pNode.parent != null) {
                TreeNode<T> parentNode = pNode.parent;
                if (parentNode.left == pNode) {
                    return parentNode;
                }
                pNode = pNode.parent;
            }
        }
        return null;
    }


}

