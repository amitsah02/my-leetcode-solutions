class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (canForm(word, wordSet)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean canForm(String word, Set<String> wordSet) {
        if (word.isEmpty()) return false;

        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string is valid

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(word.substring(j, i)) && !word.substring(j, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}