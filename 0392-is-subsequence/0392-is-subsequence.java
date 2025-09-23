class Solution {
    public boolean isSubsequence(String s, String t) {
      int i = 0; // pointer for s
        int j = 0; // pointer for t
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; // move pointer in s when chars match
            }
            j++; // always move pointer in t
        }
        
        return i == s.length(); // if all chars of s are matched

    }
}