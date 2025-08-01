class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);  // O(1) insertion
        }

        int maxLength = 0;

        for (int num : set) {
            // Only try to build sequence if num is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the streak
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                maxLength = Math.max(maxLength, currentStreak);
            }
        }

        return maxLength; 
    }
}