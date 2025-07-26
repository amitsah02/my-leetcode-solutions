class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIndex = -1;
        int minIndex = -1;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
            if(nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }

        // Front se remove karne ka count (0-based index +1)
        int frontDeletions = Math.max(minIndex, maxIndex) + 1;

        // Back se remove karne ka count (length - min(minIndex, maxIndex))
        int backDeletions = nums.length - Math.min(minIndex, maxIndex);

        // Ek front se ek back se
        int bothSidesDeletions = (Math.min(minIndex, maxIndex) + 1) + (nums.length - Math.max(minIndex, maxIndex));

        // Minimum of all 3
        int delete = Math.min(frontDeletions, Math.min(backDeletions, bothSidesDeletions));

        return delete;
    }
}
