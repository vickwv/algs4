package leetcode.string;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class LongestCommonPrefix {
    /**
     * 暴力循环法
     * 最长公共前缀的最长长度一定是字符串数组中长度最短哪个字符串。
     * 首先从数组中找出最短的字符串，比如"abcd:"
     * 依次对"abcd", "abc", "ab", "a"，判断哪个是所有其他字符串的前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int minLength = strs[0].length();
        String minString = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                minString = strs[i];
            }
        }

        String res = "";
        while (minLength > 0) {
            String subString = minString.substring(0, minLength);
            boolean isLongest = true;
            for (String str : strs) {
                if (!str.startsWith(subString)) {
                    isLongest = false;
                    break;
                }
            }
            if (isLongest) {
                res = subString;
                break;
            }
            minLength--;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        StdOut.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public String reverseWords(String s) {
        s = s.trim();
        int len = s.length();
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = len -1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                while (! stack.isEmpty()) {
                    res.append(stack.pop());
                }
                if (res.charAt(res.length()-1) != ' ') {
                    res.append(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }

        }
        while (! stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.toString();
    }
}
