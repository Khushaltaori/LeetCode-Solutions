class Solution {
    int[] dp;
    public int func(int[] nums,int i){
        if(i<0) return 0;
        if(i==0) return nums[i];

        if(dp[i]!=-1) return dp[i];

        int take = nums[i] + func(nums,i-2);
        int nontake = func(nums,i-1);

        return dp[i] = Math.max(take,nontake);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        this.dp = dp;
        Arrays.fill(dp,-1);
        return func(nums,n-1);
    }
}