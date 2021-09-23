package beauty.location;

/**
 * 功能描述：算法——0-1间浮点实数的二进制表示
 *      给定一个0-1间的实数，例如0.625，类型为double
 *          打印二进制表示为（0.101，因为小数点后的二进制分别为0.5,0.25.0.125……）
 *      如果该数字无法精确地用32位以内的二进制表示，则打印"ERROR"
 * @author RenShiWei
 * Date: 2020/3/3 10:52
 **/
public class 浮点实数的二进制表示 {

    /**
     * 功能描述：0-1间浮点实数的二进制表示
     *      每次乘2，扣除整数，直至变为0；若大于32位则报错
     * @param n 0-1的实数
     * @return n的二进制表示
     * @author RenShiWei
     * Date: 2020/3/3 11:14
     */
    private static String transform(double n){
        StringBuilder sb=new StringBuilder("0.");
        while (n>0){
            //每次乘2
            double r=n*2;
            //判断取的整数位是0还是1
            if (r>=1){
                sb.append("1");
                n=r-1;
            }else{
                sb.append("0");
                n=r;
            }
            //若大于32位则报错;34 包括 “0”和“.”
            if (sb.length()>34){
                return "ERROR";
            }
        }
        return sb.toString();
    }

    public static void main ( String[] args ) {
        System.out.println(transform(0.625));
    }

}

