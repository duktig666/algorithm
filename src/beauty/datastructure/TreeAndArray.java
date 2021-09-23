package beauty.datastructure;

/**
 * 功能描述：树结构
 *
 * @author RenShiWei
 * Date: 2020/3/27 16:16
 **/
public class TreeAndArray {

    /**
     * 树的先序遍历
     * @param arr
     * @param i
     */
    static void preOrder(int[] arr,int i){
        if (i>=arr.length){
            return;
        }
        //先输出根节点
        System.out.println(arr[i]);
        //输出左子树
        preOrder(arr,i*2+1);
        //输出右子树
        preOrder(arr,i*2+2);
    }

    /**
     * 树的中序遍历
     * @param arr
     * @param i
     */
    static void inOrder(int[] arr,int i){
        if (i>=arr.length){
            return;
        }
        //输出左子树
        inOrder(arr,i*2+1);
        //先输出根节点
        System.out.println(arr[i]);
        //输出右子树
        inOrder(arr,i*2+2);
    }


}

