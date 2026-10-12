class Solution {

    public int func(int ind,int target,int[] coins,int[][] dp){
        if(ind == 0){
            if(target % coins[ind] == 0){
                return target/coins[ind];
            }else{
                return (int) 1e9;
            }
        }

        if(dp[ind][target]!=-1) return dp[ind][target];
        //nontake 
        int nontake = func(ind-1,target,coins,dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind]<=target){
            take = 1 + func(ind,target-coins[ind],coins,dp);
        }

        return dp[ind][target] = Math.min(take,nontake);


    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }


        int ans = func(n-1,amount,coins,dp);

        if(ans >= (int) 1e9){
            return -1;
        }else{
            return ans;
        }
    }
}