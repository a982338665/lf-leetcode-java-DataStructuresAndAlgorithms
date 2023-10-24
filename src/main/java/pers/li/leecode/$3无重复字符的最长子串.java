package pers.li.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/11/2 10:29
 * @Description :
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。.
 */
public class $3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        int max = 0;
        loop:
        for (int i = 0; i < s.length(); i++) {
//            System.err.println("max000:"+max);
            //取当前字符
            Character curr = s.charAt(i);
            sb.append(curr);
            for (int j = i + 1; j < s.length(); j++) {
                Character next = s.charAt(j);
                if (sb.indexOf(next.toString()) >= 0) {
                    max = Math.max(max, sb.toString().length());
                    sb = new StringBuilder();
                    continue loop;
                } else {
                    sb.append(next);
                }
                //处理最后一位
                if (j == s.length() - 1) {
                    max = Math.max(max, sb.toString().length());
                    sb = new StringBuilder();
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        // 单个字符作为key，字符在字符串中的下标作为value
        Map<Character, Integer> map = new HashMap<>();
        // 最大值
        int maxLen = 0;
        // 左边界
        int left = 0;
        // 这个循环的一些想法，之前老喜欢把字符串转字符数组，然后用数组去操作，其实直接遍历索引也是可以的
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            /**
             * 要理解下面的代码首先要想明白获得最长字串的逻辑
             * 这里一共存在两个变量：
             *  - left：表示字串最左边字符的索引位置
             *  - i：遍历的每个字符索引位置，我们全靠这个字符来完成这道题，i这个变量存在三种情况需要考虑
             *      1） s.charAt(i)在[left, i)之间不存在重复字符
             *          - 就把s.charAt(i)放到map中，最长长度同时也加一
             *      2） s.charAt(i)在[left, i)之间存在重复字符
             *          - 获得[left, i)范围内重复字符的下标h，让left = h + 1，此时新的字串开始匹配，新的长度变成了i - left + 1 = 1
             *          - 更新map中重复字符的索引位置为i
             *      3） s.charAt(i)在[0, left)之间存在重复字符
             *          - 我们在发现重复字符后都要更新该字符在map中的索引位置，就是为了避免之前的重复元素对当前判断造成影响
             *          - 但是譬如acbba这样一个字符：当遍历到第二个b时，可知h = map.get('b')，所以h=2，那么newLeft=h+1=3;
             *              之后遍历到字符a，h = map.get('a')，发现此时h=0，newLeft=h+1=1；这种情况明显不合理，所以要求left=Math.max(left, newLeft)
             *          - 更新map中重复字符的索引位置为i，最长长度同时也加一
             *
             */
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        int i = new $3无重复字符的最长子串().lengthOfLongestSubstring("abcabcbb");
//        int i = new $3无重复字符的最长子串().lengthOfLongestSubstring("pwwkew");
//        int i = new $3无重复字符的最长子串().lengthOfLongestSubstring(" 3 ");
//        int i = new $3无重复字符的最长子串().lengthOfLongestSubstring("  ");
        int i = new $3无重复字符的最长子串().lengthOfLongestSubstring2("au");
        System.err.println(i);
    }
}
