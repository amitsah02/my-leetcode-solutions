class Solution {
    public int binaryGap(int n) {
       int last = -1;     // to store last index where '1' appeared
        int maxDist = 0;   // to store maximum distance
        int index = 0;     // current bit position (from right to left)

        while (n > 0) {
            if ((n & 1) == 1) {   // check if current bit is 1
                if (last != -1) {
                    maxDist = Math.max(maxDist, index - last);
                }
                last = index;  // update last position
            }
            n >>= 1;  // right shift to check next bit
            index++;
        }

        return maxDist; 
    }
}