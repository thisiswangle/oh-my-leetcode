package s049_group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> solution = new ArrayList<String>();
        Map<String, List<String>> fpMap = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();

            // May be smaller
            // int[] hash = new int['z' - 'a'];
            int[] hash = new int[256];
            for (int i = 0; i < chars.length; i ++) {
                hash[chars[i]] = hash[chars[i]] + 1;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < hash.length; i ++) {
                stringBuilder.append(hash[i]);
            }
            // Build a fingerprint
            String fp = stringBuilder.toString();

            List<String> s = fpMap.get(fp);
            if (null == s) {
                s = new ArrayList<String>();
            }
            s.add(str);
            fpMap.put(fp, s);
        }

        for (Map.Entry<String, List<String>> entry : fpMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                solution.addAll(entry.getValue());
            }
        }
        return solution;
    }
}
