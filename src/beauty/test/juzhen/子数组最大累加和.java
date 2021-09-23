package beauty.test.juzhen;

/**
 * 功能描述：算法-子数组最大累加和
 *➢给定一个数组arr ,返回子数组的最大累加和
 * ➢例: arr=[1,-2,3,5,-2,6,-1];所有的子数组中[3,5,-2,6]可以累加出最
 * 大的和12 ,所以返回12
 *
 * @author RenShiWei
 * Date: 2020/4/3 18:05
 **/
public class 子数组最大累加和 {

    static int findMax(int[] arr){
        if (arr.length==0){
            return 0;
        }
        int sum=arr[0];
        int max=sum;
        int left=0,right=0;
        for (int i = 1; i < arr.length; i++) {
            if(sum>=0){
                sum+=arr[i];
            }else{
                sum=arr[i];
                left=i;
            }

            if (sum>=max){
                max=sum;
                right=i;
            }
        }
        return max;
    }

}

