package s137_single_number_ii;

public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < 32; i ++) {
            int oneTimes = 0;
            res <<= 1;
            for (int j = 0; j < A.length; j ++) {
                if ((A[j] & 0x80000000) != 0)
                    oneTimes ++;

                A[j] <<= 1;
            }
            if (oneTimes % 3 == 1) {
                res |= 0x01;
            }

        }
        return res;
    }
}
