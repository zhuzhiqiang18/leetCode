package com.zzq.leetcode._3_;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str="auws";
        int result= solution.lengthOfLongestSubstring(str);
        System.out.println(result);
    }


    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }
        int ans=0;
        for (int i=0;i<s.length();i++){
            for (int j=i;j<=s.length();j++){
               if(isRepeat(s,i,j)){
                   ans=Math.max(ans,j-i);
               }
            }
        }
        return ans;
    }

    /**
     * 字符串是否重复
     */
    public boolean isRepeat(String str,int begin,int end){
        Set<Character> set = new HashSet<Character>();
        for (int k=begin;k<end;k++){
            if(set.contains(str.charAt(k))){
                return false;
            }
            set.add(str.charAt(k));
        }
        return true;
    }
}
