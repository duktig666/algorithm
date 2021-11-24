package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * description:
 * <p>
 * skuWeights = [1,3,2,4,1], boxCapacity = 7
 * <p>
 * input：
 * 1,3,2,4,1
 * 7
 * output：
 * 4
 * <p>
 * 只通过了55%，按理说不应该！ 推测难道是输入有非法字符，排序的时候，需要将非数字的元素剔除掉
 *
 * @author RenShiWei
 * Date: 2021/11/24 19:54
 **/
public class BianLiFeng3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputArr = sc.next();
        int boxCapacity = sc.nextInt();
        String[] skuWeights = inputArr.split(",");
        Arrays.sort(skuWeights);
        int sum = 0, count = 0;
        for (String sku : skuWeights) {
            sum += Integer.parseInt(sku);
            if (sum <= boxCapacity) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }

}

