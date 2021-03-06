package leetcode.bitoperation;

/**
 * description:https://leetcode-cn.com/problems/single-number-iii/
 *
 * @author RenShiWei
 * Date: 2021/12/18 20:03
 **/
public class 只出现一次的数字III_260 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        // 所有元素依次异或，得到两个出现一次元素的 异或和
        for (int num : nums) {
            xor ^= num;
        }

        /*
          取异或值最后一个二进制位为 1 的数字作为 mask，如果是 1 则表示两个数字在这一位上不同
          x & -x == x & (~x + 1)
          1. 我们都知道， 当一个奇数 + 1时， 表示的二进制数则会发生进位， 这样的话， 会产生一个连锁反应，也就是最低位的那些连续的1都会被清0, 如 :
          0000 0000 0111 1111 + 1 = 0000 0000 1000 0000
          2. 如果一个偶数, 如 0000 0100 1110， 取反后的结果就变成了 1111 1011 0001，而当这个值 + 1之后由于发生了进位， 即
          1111 1011 0001 + 1 = 1111 1011 0010
          3. 这个结果再与最初的值相与后， 只会有一位保留为1
          0000 0100 1110 & 1111 1011 0010 = 0000 0000 0010

          如果一个偶数， 在执行 x & -x的操作的时候， 最后结果肯定有如下两个特征:
          ① 这个结果只有一位值是1， 其他位均是0
          ② 这个值的末位0的个数与原值保持一致

          如果是x是奇数， 那x & -x 的结果一定是1

          总结：
          1. 当一个数与其取负后的值相与， 如果这个数是偶数， 则结果是能整除这个偶数的最大的2的幂(即： m = n & -n , 则 n % m = 0, 且 m = 2 ^ k)， 如果这个数是奇数， 则结果必为1
          2. 用途： 一般可以用来获取某个二进制数的LowBit

          x&(-x)：保留二进制下最后出现的1的位置，其余位置置0（即一个数中最大的2的n次幂的因数
          x&(x-1)：消除二进制下最后出现1的位置，其余保持不变
         */
        int mask = xor & (- xor);

        int[] ans = new int[2];
        /*
        通过与这个 mask 进行与操作，如果为 0 的分为一个数组，为 1 的分为另一个数组
        这样就把问题降低成了：“有一个数组每个数字都出现两次，有一个数字只出现了一次，求出该数字”。
        对这两个子问题分别进行全异或就可以得到两个解。也就是最终的数组了。
         */
        for (int num : nums) {
            if ((num & mask) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }

}

