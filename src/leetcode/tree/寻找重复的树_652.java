package leetcode.tree;

import common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2021/12/16 10:28
 **/
public class 寻找重复的树_652 {

    /** 记录所有子树以及出现的次数 */
    Map<String, Integer> memo = new HashMap<>();
    /** 记录重复的子树根节点 */
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    /** 辅助函数 */
    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);
        // 序列化，以当前节点为根节点的子树
        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }

}

