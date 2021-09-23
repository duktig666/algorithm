package beauty.recursion;

/**
 * 功能描述：算法——在有空字符串的有序字符串数组中查找
 *  有个排序后的字符串数组，其中散步着一些空字符串，
 *  编写一个方法，找出给定字符串（肯定不是空字符串）的索引
 *
 * @author RenShiWei
 * Date: 2020/3/11 17:47
 **/
public class 在有空字符串的有序字符串数组中查找 {

    static int indexOf(String[] arr,String p){
        int begin=0,end=arr.length-1;
        while (begin<=end){
            int mid=begin+((end-begin)>>1);
            while ("".equals(arr[mid])){
                mid++;
                //处理边界值，防止出现死循环
                if (mid>end){
                    return -1;
                }
            }
            if (arr[mid].compareTo(p)>0){
                end=mid-1;
            }else if (arr[mid].compareTo(p)<0){
                begin=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }


}

