class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
        int[] dp = new int[n];

        // Copy last row into dp
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Bottom-up DP
        for (int row = n - 2; row >= 0; row--) {
            for (int i = 0; i <= row; i++) {
                dp[i] = triangle.get(row).get(i) + Math.min(dp[i], dp[i + 1]);
            }
        }

        return dp[0]; 
    }
}