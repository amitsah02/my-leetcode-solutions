class Solution {
    public int longestPalindrome(String s) {

        int[] freq = new int[128];   // ASCII (covers A–Z, a–z)

        // count frequency
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int f : freq) {
            if (f % 2 == 0) {
                length += f;          // take all even
            } else {
                length += f - 1;     // take largest even part
                hasOdd = true;       // remember odd exists
            }
        }

        // one odd can be center
        if (hasOdd) length++;

        return length;
    }
}
