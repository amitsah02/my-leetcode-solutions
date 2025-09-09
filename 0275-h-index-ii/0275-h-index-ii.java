class Solution {
    public int hIndex(int[] citations) {
          int n = citations.length;
        int left = 0, right = n - 1;
        int hIndex = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int papers = n - mid;  

            if (citations[mid] >= papers) {
                hIndex = papers;   
                right = mid - 1;   
            } else {
                left = mid + 1;
            }
        }
        return hIndex;
    }
}