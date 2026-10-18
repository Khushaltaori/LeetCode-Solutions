class Solution {

    public int func(int ind , int amount,int[] coins,int[][] dp){
        if(ind==0){
            if(amount % coins[ind] == 0){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int nontake = func(ind-1,amount,coins,dp);
        int take = 0;
        if(coins[ind]<=amount){
            take = func(ind,amount-coins[ind],coins,dp);
        }
        return dp[ind][amount] = take+nontake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return func(n-1,amount,coins,dp);
    }
}