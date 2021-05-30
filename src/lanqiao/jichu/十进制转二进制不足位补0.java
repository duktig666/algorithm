package lanqiao.jichu;

/**
 * 功能描述：
 *
 * @author RenShiWei
 * Date: 2020/4/15 16:51
 **/
public class 十进制转二进制不足位补0 {

    public static void main ( String[] args ) {
        for (int i = 0; i < 32; i++) {
            System.out.println(toBinary(i,5));
        }
    }

    /**
     * 将一个int数字转换为二进制的字符串形式。
     * @param num 需要转换的int类型数据
     * @param digits 要转换的二进制位数，位数不足则在前面补0
     * @return 二进制的字符串形式
     */
    public static String toBinary(int num, int digits) {
        int value = 1 << digits | num;
        //保证这个string长度是digits位数
        String bs = Integer.toBinaryString(value);
        return  bs.substring(1);
    }

}

