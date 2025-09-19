class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) return result;

        // Step 1: Store word -> index in hashmap
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }

        // Step 2: For each word, split into prefix & suffix
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();

            for (int cut = 0; cut <= len; cut++) {
                String prefix = word.substring(0, cut);
                String suffix = word.substring(cut);

                // Case 1: prefix is palindrome -> need reverse(suffix)
                if (isPalindrome(prefix)) {
                    String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                    if (wordMap.containsKey(reversedSuffix) && wordMap.get(reversedSuffix) != i) {
                        result.add(Arrays.asList(wordMap.get(reversedSuffix), i));
                    }
                }

                // Case 2: suffix is palindrome -> need reverse(prefix)
                // cut != len to avoid duplicate checks
                if (cut != len && isPalindrome(suffix)) {
                    String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                    if (wordMap.containsKey(reversedPrefix) && wordMap.get(reversedPrefix) != i) {
                        result.add(Arrays.asList(i, wordMap.get(reversedPrefix)));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true; 
    }
}