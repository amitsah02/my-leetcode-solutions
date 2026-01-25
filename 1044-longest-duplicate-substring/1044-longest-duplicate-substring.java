import java.util.*;

class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s.charAt(i) - 'a';

        // 64-bit rolling hash parameters
        long mod = (1L << 61) - 1;          // big prime-like (Mersenne) modulus trick
        long base = 911382323L;             // base
        long[] pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) pow[i] = modMul(pow[i - 1], base, mod);

        int lo = 1, hi = n - 1;
        int bestLen = 0, bestStart = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int start = hasDupOfLen(a, mid, base, mod, pow);
            if (start != -1) {
                bestLen = mid;
                bestStart = start;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return bestStart == -1 ? "" : s.substring(bestStart, bestStart + bestLen);
    }

    // Returns starting index of any duplicate substring of length L, else -1
    private int hasDupOfLen(int[] a, int L, long base, long mod, long[] pow) {
        int n = a.length;
        long hash = 0;

        // initial hash for [0..L-1]
        for (int i = 0; i < L; i++) {
            hash = modAdd(modMul(hash, base, mod), a[i] + 1, mod);
        }

        // map hash -> list of start positions (to verify collisions)
        Map<Long, List<Integer>> seen = new HashMap<>();
        seen.computeIfAbsent(hash, k -> new ArrayList<>()).add(0);

        for (int i = L; i < n; i++) {
            // slide window: remove left, add right
            long left = modMul((a[i - L] + 1), pow[L - 1], mod);
            hash = modSub(hash, left, mod);
            hash = modMul(hash, base, mod);
            hash = modAdd(hash, a[i] + 1, mod);

            int start = i - L + 1;
            List<Integer> list = seen.get(hash);
            if (list != null) {
                // Verify actual substring to avoid rare collisions
                for (int prev : list) {
                    if (equalsSub(a, prev, start, L)) return start;
                }
                list.add(start);
            } else {
                seen.put(hash, new ArrayList<>(Collections.singletonList(start)));
            }
        }
        return -1;
    }

    private boolean equalsSub(int[] a, int i, int j, int L) {
        for (int k = 0; k < L; k++) {
            if (a[i + k] != a[j + k]) return false;
        }
        return true;
    }

    // --------- 61-bit mod helpers (fast & safe) ----------
    private long modAdd(long x, long y, long mod) {
        long res = x + y;
        res = (res & mod) + (res >>> 61);
        if (res >= mod) res -= mod;
        return res;
    }

    private long modSub(long x, long y, long mod) {
        long res = x - y;
        if (res < 0) res += mod;
        return res;
    }

    private long modMul(long a, long b, long mod) {
        // multiply under 2^61-1 using 128-bit via BigInteger-like split
        long au = a >>> 31, ad = a & ((1L << 31) - 1);
        long bu = b >>> 31, bd = b & ((1L << 31) - 1);

        long mid = ad * bu + au * bd;
        long midu = mid >>> 30, midd = mid & ((1L << 30) - 1);

        long res = au * bu * 2 + midu + (midd << 31) + ad * bd;
        res = (res & mod) + (res >>> 61);
        if (res >= mod) res -= mod;
        return res;
    }
}
