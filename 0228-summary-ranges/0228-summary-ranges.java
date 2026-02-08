import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();

        if (nums.length == 0) return res;

        int i = 0;

        while (i < nums.length) {
            int start = nums[i];

            // move while consecutive
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            int end = nums[i];

            if (start == end) {
                res.add(String.valueOf(start));
            } else {
                res.add(start + "->" + end);
            }

            i++;
        }

        return res;
    }
}
