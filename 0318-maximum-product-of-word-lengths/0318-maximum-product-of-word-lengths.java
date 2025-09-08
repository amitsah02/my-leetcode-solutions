class Solution {
    public int maxProduct(String[] words) {
          int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];
        
        // Step 1: Create bitmask for each word
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            masks[i] = mask;
            lens[i] = words[i].length();
        }

        int maxProduct = 0;
        
        // Step 2: Compare all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {  // No common letters
                    maxProduct = Math.max(maxProduct, lens[i] * lens[j]);
                }
            }
        }

        return maxProduct;
    
    }
}