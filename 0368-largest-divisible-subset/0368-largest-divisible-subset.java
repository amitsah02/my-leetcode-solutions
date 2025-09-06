class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int[] dp = new int[n];       // dp[i] = length of subset ending at i
        int[] parent = new int[n];   // to reconstruct the subset
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        
        int maxLen = 1, maxIndex = 0;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        
        // Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        
        return result;
    }
}