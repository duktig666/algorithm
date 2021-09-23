package beauty.recursion;

/**
 * 功能描述：算法——汉诺塔
 * 将1~N从A移动到B，C作为辅助
 * 等价于：
 * 1.将1~N-1从A移动到C，B为辅助
 * 2.N移动到B
 * 3.1~N-1从C移动到B，A为辅助
 *
 * @author RenShiWei
 * Date: 2020/3/7 15:39
 **/
public class 汉诺塔 {

    /**
     * 将N个盒子从source移动到target的路径打印
     *
     * @param n    初始的n个从小到大的盘子，n是最大盘子的编号
     * @param from 原始柱子
     * @param to   目标柱子
     * @param help 辅助柱子
     */
    static void printHanNuoTa ( int n, String from, String to, String help ) {
        if (n == 1) {
            System.out.println("move" + n + " from " + from + " to " + to);
            return;
        }
        printHanNuoTa(n - 1, from, help, to);
        System.out.println("move" + n + " from " + from + " to " + to);
        printHanNuoTa(n - 1, help, to, from);
    }

}

