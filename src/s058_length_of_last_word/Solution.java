package s058_length_of_last_word;

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;

        // Find the last non-space character
        char[] chars = s.toCharArray();
        int lastIdxOfNoSpaceChar = chars.length - 1;
        while (lastIdxOfNoSpaceChar >= 0) {
            if (chars[lastIdxOfNoSpaceChar] != ' ')
                break;
            lastIdxOfNoSpaceChar --;
        }

        // Find the last space
        int lastIdxOfSpace = lastIdxOfNoSpaceChar;
        while (lastIdxOfSpace >= 0) {
            if (chars[lastIdxOfSpace] == ' ')
                break;
            lastIdxOfSpace --;
        }

        return lastIdxOfNoSpaceChar - lastIdxOfSpace;
    }
}