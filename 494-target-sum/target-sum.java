class Solution {

    public int func(int ind, int target, int[] nums,int[][] dp) {

        if (ind == 0) {
            if (target == 0 && nums[0] == 0) return 2;
            if (target == 0 || target == nums[0]) return 1;
            return 0;
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int nontake = func(ind - 1, target, nums,dp);

        int take = 0;

        if (nums[ind] <= target) {
            take = func(ind - 1, target - nums[ind], nums,dp);
        }

        return dp[ind][target] = take + nontake;
    }

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
      
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) return 0;

        if ((totalSum - target) % 2 != 0) return 0;

        int requiredSum = (totalSum - target) / 2;

        int[][] dp = new int[n][requiredSum + 1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

        return func(n - 1, requiredSum, nums,dp);
    }
}