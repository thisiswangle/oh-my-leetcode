package s125_valid_palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        if (null == s)
            return false;
        if (s.trim().length() == 0)
            return true;

        char[] chars = s.toUpperCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;

        do {
            // find first alphanumeric char from left
            while (i < chars.length && !isAlphanumeric(chars[i])) {
                i++;
            }
            // find first alphanumeric char from right
            while (j >= 0 && !isAlphanumeric(chars[j])) {
                j--;
            }

        } while (i < chars.length && j >= 0 && i != chars.length && j != -1 && chars[i++] == chars[j--]);

        if ( i == chars.length && j == -1) {
            return true;
        }
        return false;
    }
    private boolean isAlphanumeric(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }
}
