package beauty.recursion;

/**
 * 功能描述：算法——递归的基础算法
 *      在重复中找变化，在变化中找重复
 *
 *      思维：1.切蛋糕思维
 *           2.如果不能切，思考递推公式和等价转换
 * @author RenShiWei
 * Date: 2020/3/7 10:28
 **/
public class 递归基础 {

    /**
     * 算法——n的阶乘
     * n!=1×2×3×...×n
     *  *  阶乘定义：0!=1，n!=(n-1)!×n
     *
     * f1(n):求n的阶乘-->f1(n-1)求(n-1)的阶乘
     * 找重复：n*(n-1)的阶乘，求n-1的阶乘是原问题的重复（规模更小），即转换为子问题
     * 找变化：变化的量作为参数
     * 找边界：出口（防止死循环，导致栈溢出）
     */
    static int f1(int n){
        if(n==1){
            return 1;
        }
        return n*f1(n-1);
    }

    /**
     * 打印i-j
     */
    static void f2(int i,int j){
        if (i>j){
            return;
        }
        System.out.print(i);
        f2(i+1,j);
    }

    /**
     * 对arr数组元素求和
     *
     * 数组本身是不会变化的，所以不能做递归的变化参数
     */
    static int sumArr(int[] arr,int begin){
        //两个判断边界，效果相同
        if(begin==arr.length){
            return 0;
        }
//        if (begin==arr.length-1){
//            return arr[begin];
//        }
        return arr[begin]+sumArr(arr,begin+1);
    }

    /**
     * 翻转字符串
     */
    static String reverse(String s,int end){
        if(end==0){
            return s.charAt(end)+"";
        }
        return s.charAt(end)+reverse(s,end-1);
    }

    /**
     * 功能描述：算法——斐波那契数
     *      每一项都是前两项的和
     *      示例：1 1 2 3 5 8 13 ……
     *      f(n)=f(n-1)+f(n-2)
     */
    static int fib(int n){
        if (n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    /**
     * 求最大公约数
     * m%n=0   n是两数的最大公约数
     * 若m%n=k，f(m,n)=f(n,m%n)
     */
    static int gcd(int m,int n){
        //直到n=0，求得公约数为m
        if (n==0){
            return m;
        }
        return gcd(n,m%n);
    }

    public static void main ( String[] args ) {
        System.out.println(sumArr(new int[]{1,2,3,4},0));
        System.out.println(reverse("abcd",3));
    }

}

