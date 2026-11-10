class Solution {

    public int func(int ind,int n,int[] costs,int[] dp){
        if(ind == n) return 0;

        int minCost = Integer.MAX_VALUE;
        for(int j = ind+1;j<=Math.min(n,ind+3);j++){
            if(dp[ind]!=-1) return dp[ind];
            int jumpCost = costs[j-1] + (j-ind) * (j-ind);
            int totalCost = jumpCost + func(j,n,costs,dp);

            minCost = Math.min(minCost,totalCost);


        }
        return dp[ind] =minCost;
    }
    public int climbStairs(int n, int[] costs) {
        
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return func(0,n,costs,dp);
    }
}