class Solution {
    public void moveZeroes(int[] nums) {
       int insertPos = 0;  // pointer for placing non-zero numbers
        
        // Step 1: Move all non-zero numbers forward
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        
        // Step 2: Fill the rest with zeroes
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}