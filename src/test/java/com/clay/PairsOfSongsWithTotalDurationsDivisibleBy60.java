package com.clay;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 * 形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    /**
     * 简单但超时
     */
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        for (int i = 0; i < time.length - 1; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * hash存储余数
     * 使用余数，提高缓存命中率
     * key保存当前数的余数需要的余数，word保存这个余数的需求量，在遍历时先看前面有没有需求自己的，保证了x < y
     */
    private int hashSolution(int[] time) {
        int cp = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int value : time) {
            int remainder = value % 60;
            if (map.containsKey(remainder)) {
                // 迭代累计方式
                // 找到第1个，后面再配对就是1种
                // 找到第2个，后面再配对就是2种
                cp += map.get(remainder);
            }
            if (remainder == 0) {
                // 特殊处理：余数为0的配对也是余数为0的
                map.put(0, map.getOrDefault(0, 0) + 1);
            } else {
                // 记录当前余数的配对余数
                int target = 60 - remainder;
                map.put(target, map.getOrDefault(target, 0) + 1);
            }
        }
        return cp;
    }

    /**
     * hash存储余数，压缩hash空间
     * 创建容量60的数组，利用数组下标作为余数的表示，相比Map节省了记录余数的操作
     */
    private int miniHashSolution(int[] time) {
        int cp = 0;
        int[] map = new int[60];
        for (int value : time) {
            int remainder = value % 60;
            cp += map[remainder];

            int target = remainder == 0 ? 0 : 60 - remainder;
            map[target]++;
        }
        return cp;
    }

    /**
     * 解决余数为0的逻辑
     * 在time数据范围之外找一个比最大的能整除60的time值更大的能整除60的值，这样在余数为0时就不需要特殊对待
     */
    private int smartMiniHashSolution(int[] time) {
        int cp = 0;
        int[] map = new int[60];
        for (int value : time) {
            int remainder = value % 60;
            cp += map[remainder];

            int target = (600 - value) % 60;
            map[target]++;
        }
        return cp;
    }

}
