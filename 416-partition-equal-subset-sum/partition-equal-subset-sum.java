class Solution {
     Boolean[][] dp;
    public boolean func(int[] nums,int ind,int target){

        if(target == 0) return true;
        if(ind == 0) return nums[0] == target;

        if(dp[ind][target] != null) return dp[ind][target];
        boolean nontake = func(nums,ind-1,target);
        boolean take = false;
        if(nums[ind]<=target){
            take = func(nums,ind-1,target - nums[ind]);
        }

          dp[ind][target] = nontake || take;

        return dp[ind][target];
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
       
        int totalSum = 0;
        for(int i=0;i<n;i++) totalSum += nums[i];
        if(totalSum % 2 != 0) return false;

        int target = totalSum / 2;
         dp = new Boolean[n][target + 1];
        return func(nums,n-1,target);
    }
}