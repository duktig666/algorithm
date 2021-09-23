package beauty.test.quicksort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：算法——超过一半的数字
 * 数组中有一个数字出现次数超过了数组长度的一半，找出这个数字
 * 思路：
 * 排序好之后，中位数一定是这个数
 *
 * @author RenShiWei
 * Date: 2020/3/24 15:49
 **/
public class 超过一半的数字 {

    /**
     * 解法1：排序后，返回arr[N/2],nlogn
     */
    static int solve1 ( int[] arr ) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    /**
     * 解法2：哈希表，数组元素为键，值为出现次数；当次数大于数组长度一半时，返回键
     * O(N)
     */
    static int solve2 ( int[] arr ) {
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arrMap.containsKey(arr[i])) {
                arrMap.put(arr[i], arrMap.get(arr[i]) + 1);
            } else {
                arrMap.put(arr[i], 1);
            }
            if (arrMap.get(arr[i])>arr.length/2){
                return arr[i];
            }
        }
        return 0;
    }

    /**
     * 解法3：顺序统计，O(N)
     * 快排分区思想，双向扫描
     * 限制：需要改动数组内容
     */
    static int solve3 ( int[] arr ) {
        return 第k个元素.selectK(arr,0,arr.length-1,arr.length/2);
    }

    /**
     * 解法4：消除法
     */
    static int solve4 ( int[] arr ) {
        //候选数，先定位第一个元素
        int candidate=arr[0];
        //出现的次数
        int nTime=1;
        //扫描数组
        for (int i = 0; i < arr.length; i++) {
            if (nTime==0){
                candidate=arr[i];
                nTime=1;
                continue;
            }
            //遇到和候选数相同的，次数+1
            if (arr[i]==candidate){
                nTime++;
            }else{
                //不同的进行消减
                nTime--;
            }
        }
       //一位这个数出现次数大于数组的一半，所以消减后nTime一定大，最终返回的candidate为目标值
        return candidate;
    }

    /**
     * 变化：解法4的变化——id出现次数等于所有id的一半数量
     * 这样的变化，如果每次两两都不同可能出现一定消减为0的现象
     * 这个id可能是最后一个元素。每次扫描多一个动作，和最后一个元素作比较，单独计数
     * 如果不是那么去掉最后一个元素，id就是留下的candidate
     */
    static int solve5 ( int[] arr ) {
        //候选数，先定位第一个元素
        int candidate=arr[0];
        //出现的次数
        int nTime=0;
        //统计最后元素出现的次数
        int countLast=0;
        //扫描数组
        for (int i = 0; i < arr.length; i++) {
            //增加和最后一个数比较的步骤
            if (arr[i]==arr[arr.length-1]){
                countLast++;
            }
            if (nTime==0){
                candidate=arr[i];
                nTime=1;
                continue;
            }
            //遇到和候选数相同的，次数+1
            if (arr[i]==candidate){
                nTime++;
            }else{
                //不同的进行消减
                nTime--;
            }
        }
        //如果最后一个元素出现次数是数组长度的一半
        if (countLast==arr.length/2){
            return  arr[arr.length-1];
        }else{
            return candidate;
        }
    }


    public static void main ( String[] args ) {
        int[] arr={1,2,6,8,8,8,4,8,8,8,8,1,8,8};
        System.out.println(solve1(arr));
        System.out.println(solve2(arr));
        System.out.println(solve3(arr));
        System.out.println(solve4(arr));
    }

}

