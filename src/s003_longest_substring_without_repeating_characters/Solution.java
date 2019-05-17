package s003_longest_substring_without_repeating_characters;

import java.util.Arrays;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return -1;

        int[] hash = new int[256];
        char[] chars = s.toCharArray();
        int max = 0;
        int len = 0;

        for (int i = 0; i < chars.length; i ++) {
            Arrays.fill(hash, 0);
            len = 0;
            for (int j = i; j < chars.length; j ++) {
                if (hash[chars[j]] == 0) {
                    hash[chars[j]] = 1;
                    len ++;
                    if (len > max)
                        max = len;
                } else {
                    break;
                }
            }
        }

        return max;
    }
}
