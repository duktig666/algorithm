package lanqiao.zhenti;

/**
 * description:
 * 第十届蓝桥杯题D
 *
 * @author RenShiWei
 * Date: 2020/10/7 16:03
 **/
public class 数的分解 {

    public static void main(String[] args) {
        int res = 0;
        for (int i = 1; i <= 2019; i++) {
            if (check(String.valueOf(i))) {
                for (int j = i + 1; j <= 2019; j++) {
                    if (check(String.valueOf(j))) {
                        int k = 2019 - i - j;
                        if (check(String.valueOf(k)) && k > j) {
                            res++;
                        }
                    }
                }
            }

        }
        System.out.println(res);
    }

//    public static boolean check(int n) {
//        while (n > 0) {
//            if (n % 10 == 2 || n % 10 == 4) {
//                return false;
//            } else {
//                n /= 10;
//            }
//        }
//        return true;
//    }

    //检验是否含有“2”或“4”的方法，若含有返回false
    public static boolean check(String s) {
        //若含有“2”或“4”则返回false
        if (s.contains("2") || s.contains("4")) {
            return false;
        }
        return true;
    }

}

