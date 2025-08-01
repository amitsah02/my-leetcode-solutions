class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Min is in the right part
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Min is in the left part including mid
            else {
                right = mid;
            }
        }

        return nums[left];  // or nums[right], both are same here
    }
}