package interview;

import java.util.Arrays;

/**
 * description:扑克牌问题
 *
 * @author RenShiWei
 * Date: 2021/9/26 16:59
 **/
public class Card {

    /**
     * 判断牌的类型
     * <p>
     * 返回值第一个元素的含义 (可以考虑使用枚举，进一步优化)
     * 1 代表豹子
     * 2 代表同花顺
     * 3 代表同花
     * 4 代表顺子
     * 5 代表对子
     * 6 代表单张
     *
     * @param arr 代表牌
     * @return 2个数组元素，第一个代表牌的类型，第二个代表三张牌数字之和
     */
    public int[] getCardType(int[][] arr) {
        // 越界处理
        if (arr == null || arr.length != 3) {
            throw new IllegalArgumentException("输入的牌不符合条件");
        }
        int[] result = new int[2];
        // 数组第一个元素代表牌的类型，默认为单张
        result[0] = 6;

        // 数组第二个元素代表 三张牌数字之和
        result[1] = arr[0][0] + arr[1][0] + arr[2][0];

        // 是否为豹子
        if (isBaoZi(arr)) {
            result[0] = 1;
            return result;
        }

        // 是否为同花
        if (isTongHua(arr)) {
            // 是否为同花顺 （既是同花，又是顺子）
            if (isShunZi(arr[0][0], arr[1][0], arr[2][0]) != null) {
                result = isShunZi(arr[0][0], arr[1][0], arr[2][0]);
                result[0] = 2;
                return result;
            }
            result[0] = 3;
            return result;
        }

        // 是否为顺子
        if (isShunZi(arr[0][0], arr[1][0], arr[2][0]) != null) {
            return isShunZi(arr[0][0], arr[1][0], arr[2][0]);
        }

        // 是否为对子
        if (isDuiZi(arr)) {
            result[0] = 5;
            return result;
        }

        // 最后为单张
        return result;
    }

    /**
     * 判断牌是否为 豹子
     *
     * @param arr 牌
     * @return 是否为豹子
     */
    private boolean isBaoZi(int[][] arr) {
        // 三张牌数字相同为豹子
        return arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0];
    }

    /**
     * 判断牌是否为 同花
     *
     * @param arr 牌
     * @return 是否为同花
     */
    private boolean isTongHua(int[][] arr) {
        // 三张牌花色相同为 同花
        return arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1];
    }

    /**
     * 判断牌是否为 顺子
     *
     * @param a 牌1
     * @param b 牌2
     * @param c 牌3
     * @return 是否为顺子
     */
    private int[] isShunZi(int a, int b, int c) {
        int[] result = null;
        int[] arr = {a, b, c};
        // 三张牌 排序
        Arrays.sort(arr);
        //1.特殊情况 A(14),2,3
        if (arr[0] == 2 && arr[1] == 3 && arr[2] == 14) {
            result = new int[2];
            result[0] = 4;
            result[1] = 6;
            return result;
        }
        // 2.三张牌间隔相差1
        if (arr[1] - arr[0] == 1 && arr[2] - arr[1] == 1) {
            result = new int[2];
            result[0] = 4;
            result[1] = a + b + c;
            return result;
        }
        return result;
    }

    /**
     * 判断牌是否为 对子
     *
     * @param arr 牌
     * @return 是否为对子
     */
    private boolean isDuiZi(int[][] arr) {
        return arr[0][0] == arr[1][0] || arr[0][0] == arr[2][0];
    }

    /**
     * 比较两张牌大小
     *
     * @param arr1 牌1
     * @param arr2 牌2
     * @return 1 大于; 0 相等; -1 小于;
     */
    public int compare(int[][] arr1, int[][] arr2) {
        int[] a1 = getCardType(arr1);
        int[] a2 = getCardType(arr2);
        // 级别越小越大
        if (a1[0] < a2[0]) {
            return 1;
        }
        if (a1[0] > a2[0]) {
            return - 1;
        }
        //级别相同，判断数字
        if (a1[1] < a2[1]) {
            return 1;
        }
        if (a1[1] > a2[1]) {
            return - 1;
        }
        return 0;
    }


}

