class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); // ascending
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int papersWithAtLeast = n - i; // number of papers from i..end
            h = Math.max(h, Math.min(citations[i], papersWithAtLeast));
        }
        return h; 
    }
}