package datastructure.array.sparsearray;

import org.junit.Test;

/**
 * description:稀疏数组
 *
 * @author RenShiWei
 * Date: 2021/5/24 16:51
 **/
public class SparseArray {

    /**
     * description:二维数组转稀疏数组
     *
     * @param originalArr 原始的二维数组
     * @return 稀疏数组
     * @author RenShiWei
     * Date: 2021/5/27 9:46
     */
    public int[][] arrayToSparse(int[][] originalArr) {
        //遍历原始二维数组得到有效数据的个数（方便创建稀疏数组）
        int sum = 0;
        for (int[] arr : originalArr) {
            for (int data : arr) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = originalArr.length;
        sparseArray[0][1] = originalArr[0].length;
        sparseArray[0][2] = sum;
        //记录第几个有效数据
        int count = 0;
        for (int i = 0; i < originalArr.length; i++) {
            for (int j = 0; j < originalArr[0].length; j++) {
                //不为0的数据，记录在稀疏数组
                if (originalArr[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = originalArr[i][j];
                }
            }
        }
        return sparseArray;
    }

    /**
     * description:稀疏数组转二维数组
     *
     * @param sparseArray 稀疏数组
     * @return 原始的二维数组
     * @author RenShiWei
     * Date: 2021/5/27 9:46
     */
    public int[][] sparseToArray(int[][] sparseArray) {
        int[][] originalArr = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            //稀疏数组第二行开始的数据，恢复到二维数组
            originalArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return originalArr;
    }

    /**
     * description:格式化数组输出
     *
     * @param arr 待输出的数组
     * @author RenShiWei
     * Date: 2021/5/27 9:58
     */
    public void arrayToString(int[][] arr) {
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    /**
     * description:测试用例1
     *
     * @author RenShiWei
     * Date: 2021/5/27 10:04
     */
    @Test
    public void test1() {
        int[][] arr = new int[][] {
                {0, 0, 0, 22, 0, 0, 15},
                {0, 11, 0, 0, 0, 17, 0},
                {0, 0, 0, - 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 39, 0},
                {91, 0, 0, 0, 0, 0, 0},
                {0, 0, 28, 0, 0, 0, 0}
        };
        System.out.println("---二维数组转稀疏数组---");
        int[][] sparseArray = arrayToSparse(arr);
        arrayToString(sparseArray);

        System.out.println("---稀疏数组转二维数组---");
        int[][] originalArr = sparseToArray(sparseArray);
        arrayToString(originalArr);
    }

    /**
     * description:测试用例2
     *
     * @author RenShiWei
     * Date: 2021/5/27 10:04
     */
    @Test
    public void test2() {
        int[][] arr = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        System.out.println("棋盘测试");
        System.out.println("---二维数组转稀疏数组---");
        int[][] sparseArray = arrayToSparse(arr);
        arrayToString(sparseArray);

        System.out.println("---稀疏数组转二维数组---");
        int[][] originalArr = sparseToArray(sparseArray);
        arrayToString(originalArr);
    }

}
