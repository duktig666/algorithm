package interview;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * description: 朋友的小红书 二面 算法
 * <p>
 * 假定在某国，有效的电话号码的格式为7位数字（3-4），例如888-1200，某些商家为了电话号码更方便记忆，会将电话号码记录成其他格式，例如 3-10-10-10 或者 310-EASY（310-3279）
 * 字母和数字的映射关系为：
 * A, B, and C map to 2
 * D, E, and F map to 3
 * G, H, and I map to 4
 * J, K, and L map to 5
 * M, N, and O map to 6
 * P, R, and S map to 7
 * T, U, and V map to 8
 * W, X, and Y map to 9
 * <p>
 * 现输入一些列潜在可能的电话号，希望返回出现次数大于1的电话号以及次数，电话号码按照从小到大排序
 * 例如输入：
 * 12
 * a123456
 * 123456?
 * 487--3279
 * 4873279
 * ITS-EASY
 * 888-4567
 * 3-10-10-10
 * 888-GLOP
 * TUT-GLOP
 * 967-11-11
 * 310-GINO
 * F101010
 * 888-1200
 * -4-8-7-3-2-7-9-
 * 487-3279
 * 输出：
 * 310-1010 2
 * 487-3279 4
 * 888-4567 3
 *
 * @author RenShiWei
 * Date: 2021/12/29 17:17
 **/
public class PhoneSum {

    private Map<Character, Integer> charMap;
    private Map<String, Integer> countMap;

    public PhoneSum() {
        charMap = new HashMap<>(32);
        countMap = new TreeMap<>();
        // A 65
        int word = 65;
        int num = 1;
        for (int i = 0; i < 24; i++) {
            if (i % 3 == 0) {
                num++;
            }
            if ((char) word == 'Q') {
                word++;
            }
            charMap.put((char) word, num);
            word++;
        }
    }

    private void cachePhone(String phone) {
        String replace = phone.replace("-", "");
        if (replace.length() != 7) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            char c = replace.charAt(i);
            if ((c < 48 || c > 57) && ! charMap.containsKey(c)) {
                return;
            } else if (charMap.containsKey(c)) {
                sb.append(charMap.get(c));
            } else if (c >= 48 && c <= 57) {
                sb.append(c);
            }
        }

        String key = sb.substring(0, 3) + "-" + sb.substring(3, 7);
        countMap.put(key, countMap.getOrDefault(key, 0) + 1);
    }

    private void printPhone() {
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        PhoneSum phoneSum = new PhoneSum();

        FileInputStream in = null;
        BufferedReader reader = null;
        try {
            in = new FileInputStream("src/interview/PhoneSumTest.txt");
            //InputStreamReader是转换流，将字节流转成字符流  字符输入流进行读取操作读取
            reader = new BufferedReader(new InputStreamReader(in));
            //每一行的内容
            String tempString = null;
            // 行号
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                phoneSum.cachePhone(tempString);
                line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        phoneSum.printPhone();
    }

}
