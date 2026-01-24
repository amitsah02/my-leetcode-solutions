class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Quick fail: if ransomNote is longer, cannot be formed
        if (ransomNote.length() > magazine.length()) return false;

        int[] freq = new int[26];

        // Count available letters from magazine
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            freq[ch - 'a']++;
        }

        // Try to "spend" letters for ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            freq[ch - 'a']--;

            if (freq[ch - 'a'] < 0) return false; // not enough letters
        }

        return true;
    }
}
