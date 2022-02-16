package interview;

import java.util.ArrayList;
import java.util.List;

public class BowlingBall2 {

    List<String> input = new ArrayList<>();

    public static void main(String[] args) {
        new BowlingBall2();
    }

    public BowlingBall2() {
        input.add("XXXXXXXXXXXX");
        input.add("9/9/9/9/9/9/9/9/9/9/9");
        input.add("12345432123454321234");
        input.add("X72X9/7-9/XX9/9-");
        input.add("X7/368-XX8/637/9/X");

        List<Integer> scores = getScores(input);
        System.out.println(scores);
    }

    String pre = "";

    private List<Integer> getScores(List<String> input) {
        List<Integer> res = new ArrayList<>();
        Integer score = 0;
        Integer times = 10;
        Integer num = 2;
        Integer g = 0;
        String index, second, third = "";
        for (String str : input) {
            while (times > 0) {
                // 取出第一次结果
                index = str.substring(0, 1);
                if (! "/".equals(index)) {
                    check2(str);
                }
                score = sum(score, index);
                // 如果X是第一次结果
                switch (index) {
                    case "X":
                        // 直接截取第一个，并且把第二个，第三个拿出来，计算完成，将以计算结果移除
                        second = str.substring(1, 2);
                        score = sum(score, second);
                        third = str.substring(2, 3);
                        score = sum(score, third);
                        str = str.substring(1, str.length());
                        times--;
                        num = 2;
                        break;
                    case "/":
                        // 直接截取第一个，并且把第二个，计算完成，将以计算结果移除
                        second = str.substring(1, 2);
                        score = sum(score, second);
                        str = str.substring(1, str.length());
                        times--;
                        num = 2;
                        break;
                    default:
                        // 如果不是特殊情况，剔除相加
                        str = str.substring(1, str.length());
                        num--;
                        if (num == 0) {
                            times--;
                            num = 2;
                        }
                        break;
                }
            }
            res.add(score);
            score = 0;
            times = 10;
            num = 2;
        }
        return res;
    }

    private void check2(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if ("/".equals(str.substring(i, i + 1))) {
                pre = str.substring(i - 1, i);
                return;
            }
        }
    }
    //
    //private Integer check(Integer score, String s, String str) {
    //    if ("/".equals(s)) {
    //        String[] split = str.split("/");
    //        String first = split[0];
    //        pre = first.substring(first.length()-1, first.length());
    //        score = sum(score, s,pre);
    //    } else {
    //        score = sum(score, s);
    //    }
    //    return score;
    //}


    private Integer sum(Integer score, String s) {
        switch (s) {
            case "X":
                return score + 10;
            case "/":
                return score + 10 - Integer.parseInt(pre);
            case "-":
                return score;
            default:
                return score + Integer.parseInt(s);
        }
    }


}
