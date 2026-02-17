import java.util.*;

class Solution {

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        // Step 1: find all positions of a
        for (int i = 0; i + a.length() <= s.length(); i++) {
            if (s.substring(i, i + a.length()).equals(a)) {
                A.add(i);
            }
        }

        // Step 2: find all positions of b
        for (int i = 0; i + b.length() <= s.length(); i++) {
            if (s.substring(i, i + b.length()).equals(b)) {
                B.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        // Step 3: two pointer check
        int j = 0;

        for (int i : A) {

            while (j < B.size() && B.get(j) < i - k) {
                j++;
            }

            if (j < B.size() && Math.abs(B.get(j) - i) <= k) {
                ans.add(i);
            }
        }

        return ans;
    }
}
