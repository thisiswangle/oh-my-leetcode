package s015_3sum;


import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3)
            return solutions;

        Arrays.sort(num);

        Set<String> set = new HashSet<String>();
        for (int i = 0; i < num.length; i++) {
            // Keep the num[i] as sum, find 2-sum in a sorted array
            int left = 0;
            if (i == 0)
                left = 1;

            int right = num.length - 1;
            if (i == num.length - 1)
                right = num.length - 2;

            int expected = 0 - num[i];
            int twoSum = num[left] + num[right];

            while (right > left && left < i && right > i) {
                while (twoSum > expected && right > 0 && left <= num.length - 1 && right > left) {
                    right --;
                    if (right == i)
                        continue;

                    twoSum = num[left] + num[right];
                }

                while (twoSum < expected && left < num.length - 1 && right >= 0 && right > left) {
                    left ++;
                    if (left == i)
                        continue;
                    twoSum = num[left] + num[right];
                }

                if (twoSum == expected && right != left && right >= 0 && left <= num.length - 1) {
                    List<Integer> s = buildASortedTriple(num[left], num[right], num[i]);
                    String fp = new StringBuilder().append(s.get(0)).append(s.get(1)).append(s.get(2)).toString();
                    if (!set.contains(fp)) {
                        set.add(fp);
                        solutions.add(s);
                    }
                    right --;
                    left ++;
                    if (left <= num.length-1 && right >= 0)
                        twoSum = num[left] + num[right];
                }
            }
        }
        return solutions;
    }

    private List<Integer> buildASortedTriple(int a, int b, int c) {
        List<Integer> s = new ArrayList<Integer>();
        if (c < a) {
            s.add(c);
            s.add(a);
            s.add(b);
        } else if (c > b) {
            s.add(a);
            s.add(b);
            s.add(c);
        } else {
            s.add(a);
            s.add(c);
            s.add(b);
        }
        return s;
    }

}