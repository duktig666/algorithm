package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * description:
 * 便利蜂仓库每日为门店提供商品配货服务，商品分布在不同的货位上，拣货员每天要在不同的货位拣刚解开，、n选商品为门店配货，
 * 给出一组货位的分布情况，按给定货位的顺序进行拣货，假定仓库每个货位之间的间隔距离均相等的（包括纵、横、45度角方向），且拣货员分别要从这些货位上进行拣货，
 * 为了尽量减少拣货员的冗余移动，请在给定的货位分布中，输出拣货员拣货的最优移动次数
 * <p>
 * 约束 以D[x,y]表示一个货位的坐标，DP[D1,D2]表示一组货位  P[x,y]表示拣货员的位置，货位数为N，坐标间最小间隔1个距离单位
 * x,y都是整数，且满足 -100 <= x,y <= 100;
 * P ∈ {D},即拣货员的坐标只能是一组货位坐标中的某一个;总是以拣货员的坐标作为起始点
 * 0 < N <= 10, DP[i].length == 2, P.length == 2
 * <p>
 * 不符合规则的输入，输出-1
 * 拣货员没有超能力，不能攀爬不能飞不能跳跃货位
 * <p>
 * 输入描述
 * 第一行：货位坐标，以[x,y]标注二维坐标位置，数据间以分号隔开
 * 第二行：拣货员的位置，上述货位坐标中的某一个，以x,y表述坐标。
 * 以D[x,y]表示一个货位的坐标，DP[D1,D2]表示一组货位，P[x,y]表示拣货员的位置，货位数为N，坐标间最小间隔1个距离单位
 * x,y都是整数，且满足 -100 <= x,y <= 100;
 * P ∈ {D},即拣货员的坐标只能是一组货位坐标中的某一个;总是以拣货员的坐标作为起始点
 * 0 < N <= 10, DP[i].length == 2, P.length == 2
 * <p>
 * 输出描述
 * 拣货员拣货的最优移动次数（数字）。
 * <p>
 * 示例：移动了6次：[3,4] -->[3,3] -->[2,2] -->[1,1] -->[0,0] -->[-1,-1] -->[-2,-1] 。
 * s
 *
 * @author RenShiWei
 * Date: 2021/11/24 20:44
 **/
public class BianLiFeng2 {

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

