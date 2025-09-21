
class Solution {
    public int xorOperation(int n, int start) {
        int nums[] = new int[n];
        int res = start;
        nums[0]= start;
        for(int i=1; i<=n-1; i++){
          nums[i] = start + 2 * i;
             res =  res ^ nums[i];
        }
        return res;
    }
}