package beauty.test.string;

/**
 * 功能描述：算法-字符串压缩
 * 例如："aabcccccaaa"——》"a2b1c5a3"
 * 如果字符串没有变短，返回原数组
 *
 * @author RenShiWei
 * Date: 2020/4/3 21:08
 **/
public class 字符串压缩 {

    static String zipString ( String str ) {
        //记录前一个字符串的重复次数
        int count = 0;
        //记录上一个字符
        char last = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            //处理第一个字符
            if (sb.length() == 0) {
                sb.append(charAt);
            } else {
                //如果和上一个字符相同
                if (last == charAt) {
                    count++;
                } else {
                    //如果和上一个字符不同
                    sb.append(count).append(charAt);
                    count = 1;
                }
            }
            last=charAt;
        }
        //处理最后一个字符的次数
        if (count>=1){
            sb.append(count);
        }
        if (sb.length()>=str.length()){
            return str;
        }
        return sb.toString();
    }
}

