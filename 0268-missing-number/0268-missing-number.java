class Solution {
    public int missingNumber(int[] nums) {
        int x_nor = nums.length;
        for(int i =0; i<nums.length; i++){
            x_nor = x_nor ^ i;
            x_nor = x_nor ^ nums[i];
        }
        return x_nor;
    }
}