package s018_4sum;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        Map<String, String> fps = new HashMap<>();
        if (num == null || num.length < 4)
            return solutions;

        Arrays.sort(num);

        // Choose two numbers for num array first
        // and divide this problem to a 2Sum problem
        for (int i = 0; i < num.length; i ++) {
            for (int j = i + 1; j < num.length; j ++) {
                int sum = num[i] + num[j];
                int expected = target - sum;
                List<int[]> solutionsTwoSum = twoSum(sub(num, i, j), expected);
                if (solutionsTwoSum != null) {
                    for (int[] solutionTwoSum : solutionsTwoSum) {
                        List<Integer> solution = new ArrayList<>(4);

                        // Merge Sort
                        List<Integer> s = merge(solutionTwoSum, new int[]{num[i], num[j]});
                        String fp = s.toString();
                        if (!fps.containsKey(fp)) {
                            fps.put(fp, null);
                            solutions.add(s);
                        }
                    }
                }
            }
        }
        return solutions;
    }

    private List<Integer> merge(int[] a, int[] b) {
        List<Integer> solution = new ArrayList<>(4);
        int i = 0, j = 0;
        while (true) {
            while (i < a.length && j < b.length && a[i] <= b[j]) {
                solution.add(a[i]);
                i ++;
            }
            while (j < b.length && i < a.length && a[i] > b[j]) {
                solution.add(b[j]);
                j ++;
            }

            if (i == a.length || j == b.length)
                break;
        }

        for (int k = i; k < a.length; k ++)
            solution.add(a[k]);

        for (int k = j; k < b.length; k ++)
            solution.add(b[k]);

        return solution;
    }

    private int[] sub(int[] num, int ii, int ij) {
        int[] newnum = new int[num.length - 2];
        for (int i = 0, j = 0; i < num.length; i ++)
            if (i != ii && i != ij)
                newnum[j++] = num[i];
        return newnum;
    }

    private  List<int[]> twoSum(int[] num, int expected) {
        List<int[]> solutions = new ArrayList<>();
        int left = 0;
        int right = num.length - 1;

        int sum = num[left] + num[right];
        while (left < right) {
            // From left to right
            while(sum < expected && left < right) {
                left ++;
                sum = num[left] + num[right];
            }

            // From right to left
            while(sum > expected && left < right) {
                right --;
                sum = num[left] + num[right];
            }

            if (sum == expected && left < right) {
                solutions.add(new int[]{num[left], num[right]});
                left ++;
                right --;
                if (left >= right)
                    break;
                sum = num[left] + num[right];
            }
        }
        return solutions;
    }
}