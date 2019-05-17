package s004_median_of_two_sorted_arrays;

import java.util.Arrays;

// Best solution:
// https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/284794/Java.-Faster-than-100.-2-ms.-O(min(log-m-log-n))-time-O(1)-space
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // The last operation of merge sort
        // O(m+n)?
        int length = nums1.length + nums2.length;
        int[] num = new int[length];

        int p1 = 0, p2 = 0, p = 0;

        while (p < length) {
            if (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] < nums2[p2]) {
                    num[p++] = nums1[p1++];
                } else {
                    num[p++] = nums2[p2++];
                }
            }

            if (p1 < nums1.length && p2 >= nums2.length) {
                num[p++] = nums1[p1++];
            }

            if (p1 >= nums1.length && p2 < nums2.length) {
                num[p++] = nums2[p2++];
            }
        }

        //System.out.println(Arrays.toString(num));

        if (length % 2 == 0) {
            return (num[length / 2] + num[length / 2 - 1]) / 2.0;
        } else {
            return num[length / 2] / 1.0;
        }
    }

    public static void main(String[] args) {
        double r = new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{});
        System.out.println(r);
        r = new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(r);
    }
}
