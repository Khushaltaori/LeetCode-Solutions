class Solution {
    char[][] grid;
    Boolean[][][] dp;
    public boolean func(int i,int j,int balance){
        if(i<0 || j<0) return false;

        

        if(grid[i][j]== '('){
            balance--;
        }else{
            balance++;
        }


        if(balance<0) return false;

         if(i==0 && j == 0) return balance == 0;
        if(dp[i][j][balance]!=null) return dp[i][j][balance];

        boolean up = func(i-1,j,balance);
        boolean left = func(i,j-1,balance);
        
        return dp[i][j][balance] = up || left;
    }
    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        Boolean[][][] dp = new Boolean[m][n][m + n - 1];
        this.dp = dp;
        
        return func(m-1,n-1,0);
    }
}