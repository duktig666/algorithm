package beauty.test.string;

/**
 * 功能描述：算法——去掉连续出现k次的0
 * <p>
 * 可以使用扫描字符数组的解法，但是用正则表达式更为快捷
 *
 * @author RenShiWei
 * Date: 2020/4/4 16:35
 **/
public class 去掉连续出现k次的0 {

    /**
     * 使用正则解法
     */
    static String remove ( String str, int k ) {
        String regexp = "0{" + k + "}";
        return str.replaceAll(regexp, "");
    }

    /**
     * 使用字符数组扫描解法
     */
    static String remove2 ( String str, int k ) {
        char[] arr = str.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '0') {
                count++;
            } else {
                //不是0，将之前出现的0添加进去
                for (int j = 0; j < count % k; j++) {
                    sb.append('0');
                }
                sb.append(c);
            }
        }
        //最后出现0，需要添加进去
        for (int i = 0; i <  count % k; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

}

