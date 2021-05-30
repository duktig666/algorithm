package lanqiao.zhenti;

/**
 * description:
 *
 * @author RenShiWei
 * Date: 2020/10/7 15:30
 **/
public class test {

    public static void main(String[] args) {
        int arr[]=new int[20190325];
        arr[1]=1;
        arr[2]=1;
        arr[3]=1;
        for(int i=4;i<20190325;i++){
            arr[i]+=(arr[i-1]+arr[i-2]+arr[i-3]);
            arr[i]%=10000;
        }
        System.out.println(arr[20190324]);
    }


}

