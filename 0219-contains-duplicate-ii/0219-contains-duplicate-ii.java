class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Declare the map here

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true; // found duplicate within k distance
            }
            map.put(nums[i], i); // update last seen index
        }
        return false; 
    }
}