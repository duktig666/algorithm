package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * description: 710. 黑名单中的随机数 #@see https://leetcode-cn.com/problems/random-pick-with-blacklist/
 *
 * @author RenShiWei
 * Date: 2021/12/3 11:19
 **/
public class BlackListRandom {

    /** 数组中黑明的分界线[sz,n)为黑名单的数 */
    int sz;
    /** 黑名单的映射 */
    Map<Integer, Integer> map;

    Random random = new Random();

    public BlackListRandom(int n, int[] blacklist) {
        map = new HashMap<>();
        sz = n - blacklist.length;
        // 初始化映射表
        for (int b : blacklist) {
            map.put(b, 0);
        }
        int last = n - 1;
        for (int b : blacklist) {
            // 如果 b 已经在区间 [sz, N) , 可以直接忽略
            if (b >= sz) {
                continue;
            }
            // 跳过无效索引
            while (map.containsKey(last)) {
                last--;
            }
            map.put(b, last);
            last--;
        }
    }

    public int pick() {
        // 随机选取⼀个索引
        int index = random.nextInt(sz);
        return map.getOrDefault(index, index);
    }

}

