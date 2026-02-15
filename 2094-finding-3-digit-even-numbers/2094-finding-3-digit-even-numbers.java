import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {

        Set<Integer> set = new TreeSet<>();

        int n = digits.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {

                    if(i == j || j == k || i == k) continue;

                    int num = digits[i]*100 + digits[j]*10 + digits[k];

                    if(digits[i] != 0 && num % 2 == 0) {
                        set.add(num);
                    }
                }
            }
        }

        int[] result = new int[set.size()];
        int idx = 0;

        for(int x : set) {
            result[idx++] = x;
        }

        return result;
    }
}
