package beauty.test.string;

/**
 * 功能描述：算法——旋转词
 * defabd——>fabdde    true
 *
 * 即，字符串是否为两个相同拼接字符串的子序列，即可判断
 * @author RenShiWei
 * Date: 2020/4/4 16:15
 **/
public class 旋转词 {

    static boolean isRotate(String a,String b){
        if (a.length()!=b.length()){
            return false;
        }
        StringBuilder sb=new StringBuilder(b).append(b);
        return sb.toString().contains(b);
    }

}

