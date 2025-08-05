class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--; // Shift for 1-based indexing (A = 1)
            int remainder = columnNumber % 26;
            char ch = (char) (remainder + 'A');
            result.insert(0, ch); // Prepend the character
            columnNumber /= 26;
        }
        
        return result.toString();
    }
}