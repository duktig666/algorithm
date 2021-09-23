package beauty.test.string;

/**
 * 功能描述：算法——字符串按单词翻转
 * 例如：here you are   ——》 are you here
 *
 * @author RenShiWei
 * Date: 2020/4/4 16:21
 **/
public class 字符串按单词翻转 {

    static String reverse(String str){
        //先翻转字符串
        String s=reverseString(str);
        String[] words=s.split("\\s");
        StringBuilder sb=new StringBuilder();
        //在翻转每个单词
        for (int i = 0; i <words.length ; i++) {
            sb.append(reverseString(words[i])+" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    static String reverseString(String str){
        StringBuilder sb=new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main ( String[] args ) {
        System.out.println(reverse("here you are"));
    }
}

