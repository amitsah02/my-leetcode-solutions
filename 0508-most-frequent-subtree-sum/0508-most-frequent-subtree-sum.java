import java.util.*;

class Solution {
    private Map<Integer, Integer> freq = new HashMap<>();
    private int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() == maxFreq) ans.add(e.getKey());
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int sum = node.val + left + right;

        int c = freq.getOrDefault(sum, 0) + 1;
        freq.put(sum, c);
        if (c > maxFreq) maxFreq = c;

        return sum;
    }
}
