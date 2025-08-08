class Solution {
    public String toHex(int num) {
         if (num == 0) return "0";

        // Hexadecimal characters
        char[] hexChars = "0123456789abcdef".toCharArray();
        
        StringBuilder sb = new StringBuilder();

        // We use unsigned shift >>> so that for negative numbers,
        // the leftmost bits are filled with 0s (two's complement handled)
        while (num != 0) {
            int hexValue = num & 0xf; // get last 4 bits
            sb.append(hexChars[hexValue]);
            num >>>= 4; // shift right by 4 bits
        }

        // Reverse because we appended from least significant to most significant
        return sb.reverse().toString();
    }
}