class Solution {
    public int longestNiceSubarray(int[] nums) {

        int left = 0;
        int mask = 0;   // stores OR of current window
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            // jab tak conflict hai (common bit exists)
            while ((mask & nums[right]) != 0) {
                // remove nums[left] from mask
                mask ^= nums[left];
                left++;
            }

            // add current number to window
            mask |= nums[right];

            // update answer
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
