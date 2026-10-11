class Solution {
    public int func(int[] coins,int ind,int target,int[][] dp){
        //base case
        if(ind == 0){
            if(target % coins[ind]==0){
                return target/coins[ind];
            }else{
                return (int) 1e9;
            }
        }

        if(dp[ind][target]!=-1) return dp[ind][target];
        int nontake = func(coins,ind-1,target,dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind]<=target){
            take = 1+func(coins,ind,target-coins[ind],dp);
        }

        return dp[ind][target] = Math.min(take,nontake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[]rows : dp){
            Arrays.fill(rows,-1);
        }

        int ans =  func(coins,n-1,amount,dp);
        if(ans >= (int) 1e9){
            return -1;
        }else{
            return ans;
        }
    }
}