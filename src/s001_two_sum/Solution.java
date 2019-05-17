package s001_two_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null)
            return new int[]{};

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numbers.length; i++) {
            List<Integer> idxes = null;
            if (map.containsKey(numbers[i])) {
                idxes = map.get(numbers[i]);
            } else {
                idxes = new ArrayList<Integer>();
            }
            idxes.add(i);
            map.put(numbers[i], idxes);
        }

        for (int i = 0; i < numbers.length; i++) {
            int expected = target - numbers[i];
            if (map.containsKey(expected)) {
                int idx1 = i;
                int idx2 = -1;
                List<Integer> idxes = map.get(expected);
                if (expected == numbers[i]) {
                    if (idxes.size() > 1) {
                        for (int idx : idxes) {
                            if (idx != idx1) {
                                idx2 = idx;
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    idx2 = idxes.get(0);
                }

                int tmp = idx2;
                if (idx1 > idx2) {
                    idx2 = idx1;
                    idx1 = tmp;
                }
                return new int[]{idx1 + 1, idx2 + 1};
            }
        }
        return new int[]{};
    }
}