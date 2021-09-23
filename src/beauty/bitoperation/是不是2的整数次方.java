package beauty.bitoperation;

/**
 * 功能描述：算法——整数是不是2的整数次方
 * 要求：用一条语句判断
 * 整数是2的整数次方的数，二进制只有一个1
 *
 * @author RenShiWei
 * Date: 2020/3/3 8:49
 **/
public class 是不是2的整数次方 {

    /**
     * 功能描述：判断数是不是2的整数次方
     * 整数是2的整数次方的数，二进制只有一个1
     * 如果可以一次消除1之后变为0，说明是2的整数次方
     *
     * @param n 待判断的数
     * @return 是否
     * @author RenShiWei
     * Date: 2020/3/3 9:00
     */
    public static boolean isTwoNum(int n) {
        return ((n - 1) & n) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isTwoNum(32));
        System.out.println(isTwoNum(31));
    }

}

