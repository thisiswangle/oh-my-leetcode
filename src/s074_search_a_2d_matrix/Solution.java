package s074_search_a_2d_matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lefttop = 0;
        int rightbottom = matrix[0].length * matrix.length - 1;
        return binarySearch(matrix, target, lefttop, rightbottom);
    }

    private boolean binarySearch(int[][]matrix, int target, int lefttop, int rightbottom) {
        if (lefttop > rightbottom)
            return false;

        int mid = (lefttop + rightbottom) / 2;
        int[] idxs = mapIdx(matrix[0].length, mid);

        if (target == matrix[idxs[0]][idxs[1]])
            return true;
        else if (target < matrix[idxs[0]][idxs[1]]) {
            return binarySearch(matrix, target, lefttop, mid - 1);
        }
        else { //target > matrix[idxs[0]][idxs[1]])
            return binarySearch(matrix, target, mid + 1, rightbottom);
        }
    }

    private int[] mapIdx(int d1len, int curr) {
        int[] idxs = new int[2];
        idxs[0] = curr / d1len;
        idxs[1] = curr - idxs[0] * d1len;
        return idxs;
    }
}
