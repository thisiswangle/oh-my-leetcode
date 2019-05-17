package s036_valid_sudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = 9;
        int[] hash = null;
        for (int i = 0; i < size; i ++) {
            hash = new int[10];
            for (int j = 0; j < size; j ++) {
                if (board[i][j] == '.')
                    continue;
                else {
                    int num = board[i][j] - '0';
                    if (hash[num] == 0) {
                        hash[num] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < size; i ++) {
            hash = new int[10];
            for (int j = 0; j < size; j ++) {
                if (board[j][i] == '.')
                    continue;
                else {
                    int num = board[j][i] - '0';
                    if (hash[num] == 0) {
                        hash[num] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i ++)
            for (int j = 0; j < 3; j ++) {
                hash = new int[10];
                for (int k = i * 3; k < i * 3 + 3; k ++)
                    for (int l = j * 3; l < j * 3 + 3; l ++) {
                        if (board[k][l] == '.')
                            continue;
                        else {
                            int num = board[k][l] - '0';
                            if (hash[num] == 0) {
                                hash[num] = 1;
                            } else {
                                return false;
                            }
                        }
                    }
            }

        return true;
    }
}