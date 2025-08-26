class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        while (result.size() < n) {
            List<Integer> next = new ArrayList<>();
            
            // odd numbers
            for (int x : result) {
                if (2 * x - 1 <= n) {
                    next.add(2 * x - 1);
                }
            }

            // even numbers
            for (int x : result) {
                if (2 * x <= n) {
                    next.add(2 * x);
                }
            }

            result = next;
        }

        // convert List<Integer> to int[]
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}