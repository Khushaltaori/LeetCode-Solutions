class Solution {
    int[] dp;
    public int func(int i,int[] cost){
        if(i >= cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        return  dp[i] = cost[i] + Math.min(func(i+1,cost),func(i+2,cost));

        
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        this.dp = dp;
        Arrays.fill(dp,-1);
        return Math.min(func(0,cost),func(1,cost));
    }
}