class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen =0;
        int left =0;
        
        HashSet<Character> set = new HashSet<>();
        for(int right =0; right<s.length(); right ++){
            char ch = s.charAt(right);
            while(set.contains(ch)){
                 set.remove(s.charAt(left));
                 left ++;
            }
            set.add(ch);
           maxlen = Math.max(maxlen, right-left+1);
        }

        return maxlen;
    }
}