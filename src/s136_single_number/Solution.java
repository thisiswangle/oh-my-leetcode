package s136_single_number;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] A) {
        Map<Integer, Object> map = new HashMap<Integer, Object>();
        Object object = new Object();
        for (int num : A) {
            if(map.get(num) == null)
                map.put(num, object);
            else
                map.remove(num);
        }

        for (Integer exp: map.keySet()){
            return exp;
        }
        return 0;
    }
}