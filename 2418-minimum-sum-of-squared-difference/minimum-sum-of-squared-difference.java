import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long k = (long) k1 + k2;

        long[] diff = new long[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
        }

        Arrays.sort(diff);

        // If we can make every difference 0
        long total = 0;
        for (long d : diff) {
            total += d;
        }

        if (k >= total) {
            return 0;
        }

        // Binary search the final maximum difference
        long low = 0;
        long high = diff[n - 1];

        while (low < high) {

            long mid = (low + high) / 2;

            long required = 0;

            for (long d : diff) {
                if (d > mid) {
                    required += d - mid;

                    if (required > k)
                        break;
                }
            }

            if (required <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long limit = low;

        // Reduce all differences above limit to limit
        long used = 0;

        for (int i = 0; i < n; i++) {
            if (diff[i] > limit) {
                used += diff[i] - limit;
                diff[i] = limit;
            }
        }

        // Remaining operations should reduce some elements from limit to limit-1
        long remaining = k - used;

        for (int i = n - 1; i >= 0 && remaining > 0; i--) {
            if (diff[i] == limit) {
                diff[i]--;
                remaining--;
            }
        }

        // Calculate answer
        long ans = 0;

        for (long d : diff) {
            ans += d * d;
        }

        return ans;
    }
}