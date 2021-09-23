package beauty.utils;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/3/2 15:57
 **/
public class Util {

    /**
     * 功能描述：在数组中交换两个元素的位置
     * @param arr 目标数组
     * @param i j  i位置和j位置元素交换
     * @author RenShiWei
     * Date: 2020/3/2 15:57
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 功能描述： 将目标数组输出
     * @param arr 输出的目标数组
     * @author RenShiWei
     * Date: 2020/3/2 16:04
     */
    public static void printArr(int[] arr){
        StringBuilder result=new StringBuilder();
        result.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i<arr.length-1){
                result.append(arr[i]).append(",");
            }else{
                //最后一个元素不输出","
                result.append(arr[i]);
            }
        }
        result.append("]");
        System.out.println(result.toString());
    }

    public static void printMatrix(int[][] matrix){
        for(int[] arr:matrix){
            for(int value:arr){
                System.out.print(value+"\t");
            }
            System.out.println();
        }
    }

}

