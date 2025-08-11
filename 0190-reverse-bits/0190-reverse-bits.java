class Solution {
    public int reverseBits(int n) {
          int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev <<= 1;           // shift rev to the left to make space
            rev |= (n & 1);      // add the last bit of n to rev
            n >>>= 1;            // logical right shift (fills with 0s)
        }
        return rev;
    }
}