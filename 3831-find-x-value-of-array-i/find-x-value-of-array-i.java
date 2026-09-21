class Solution {

    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        // dp[r] = number of subarrays ending at previous index
        //         with product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            long[] next = new long[k];

            // 1. Start a new subarray [num]
            int rem = num % k;
            next[rem]++;

            // 2. Extend every previous subarray
            for (int r = 0; r < k; r++) {

                if (dp[r] == 0) {
                    continue;
                }

                int newRem = (int)(((long) r * num) % k);

                next[newRem] += dp[r];
            }

            // All subarrays ending at current index
            // contribute to the final answer
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}