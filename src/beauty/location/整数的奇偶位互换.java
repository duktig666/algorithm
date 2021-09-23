package beauty.location;

/**
 * 功能描述：交换一个整数的二进制奇偶位
 *
 * @author RenShiWei
 * Date: 2020/3/3 9:04
 **/
public class 整数的奇偶位互换 {

    private static int transform ( int n ) {
        //假设n, xyxy xyxy xyxy ……
        //32位太麻烦，所以用16进制来表示
        //和 1010 1010 1010 …… 做与运算，取出奇数位  ——>x0x0 x0x0 x0x0 ……
        int ji = n & 0xaaaaaaaa;
        //和 0101 0101 0101 …… 做与运算，取出偶数位  ——>0y0y 0y0y 0y0y ……
        int ou = n & 0x55555555;
        //连起来为 yxyx yxyx yxyx ……
        return (ji >> 1) ^ (ou << 1);
    }

    private static int transform2 ( int n ) {
        //将数转换为二进制的字符串
        String s=Integer.toBinaryString(n);
        char [] strArr = s.toCharArray();
        for (int i = 1; i < strArr.length; i+=2) {
            strArr[i]= (char) (strArr[i]^strArr[i-1]);
            strArr[i-1]= (char) (strArr[i]^strArr[i-1]);
            strArr[i]= (char) (strArr[i]^strArr[i-1]);
        }
        return Integer.parseInt(String.valueOf(strArr),2);
    }

    public static void main ( String[] args ) {
        System.out.println(transform(6));
        System.out.println(transform2(6));
    }

}

