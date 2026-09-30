class Solution {

    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, equal partition is impossible
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        int[][] dp = new int[n][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(nums, n - 1, target, dp);
    }

    static boolean func(int[] nums, int index, int sum, int[][] dp) {

        // We successfully formed the target
        if (sum == 0) {
            return true;
        }

        // Only nums[0] is left
        if (index == 0) {
            return nums[0] == sum;
        }

        // Already calculated
        if (dp[index][sum] != -1) {
            return dp[index][sum] == 1;
        }

        // Don't take nums[index]
        boolean notTake = func(nums, index - 1, sum, dp);

        // Take nums[index]
        boolean take = false;

        if (nums[index] <= sum) {
            take = func(nums, index - 1, sum - nums[index], dp);
        }

        boolean ans = take || notTake;

        dp[index][sum] = ans ? 1 : 0;

        return ans;
    }
}