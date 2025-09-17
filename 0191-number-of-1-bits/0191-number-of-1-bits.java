class Solution {
    public int hammingWeight(int n) {
       int count = 0;
        while (n != 0) {
            // check last bit
            count += (n & 1);  
            // shift right (>>> for unsigned shift)
            n = n >>> 1;
        }
        return count;
    }
}