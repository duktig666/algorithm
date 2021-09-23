package beauty.test.string;

/**
 * 功能描述：算法——替换空格
 *
 * @author RenShiWei
 * Date: 2020/4/3 20:53
 **/
public class 替换空格 {

    static String replaceSpace(String str){
        return str.replaceAll("\\s","%20");
    }

    static String replaceSpace2(String str){
        int count=str.length();
        for (int i = 0; i <str.length() ; i++) {
            if (str.toCharArray()[i]==' '){
                count+=2;
            }
        }
        int p1=str.length()-1,p2=count-1;
        while (p1>=0){
            if (str.toCharArray()[p1]==' '){
                str.toCharArray()[p2--]='0';
                str.toCharArray()[p2--]='2';
                str.toCharArray()[p2--]='%';
            }else{
                str.toCharArray()[p2--]=str.toCharArray()[p1];
            }
            p1--;
        }
        return new String(str.toCharArray(),0,count);
    }

}

