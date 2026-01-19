class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        HashSet<Character> set = new HashSet<>();

        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);

            // If character is already in the set, shrink the window
            while (set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }

            // Add the current character to the set
            set.add(c);

            // Update the maximum length
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}