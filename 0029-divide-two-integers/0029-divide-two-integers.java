class Solution {
    public int divide(int dividend, int divisor) {
        // Edge Case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Convert both numbers to long to avoid overflow, and work with positives
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;

        // Subtract divisor from dividend using bit shifting (double the divisor)
        while (a >= b) {
            long temp = b, multiple = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }

        // Determine sign
        if ((dividend > 0) != (divisor > 0)) {
            result = -result;
        }

        return result;
    }
}
