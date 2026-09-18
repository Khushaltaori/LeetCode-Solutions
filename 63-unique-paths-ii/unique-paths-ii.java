class Solution {
    int[][] obstacleGrid;
    public int func(int i,int j , int[][] dp){
        

        if(i<0 || j < 0) return 0;
        if(obstacleGrid[i][j]==1) return 0;
        if(i == 0 && j == 0) return 1;

        if(dp[i][j]!=-1) return dp[i][j];
        int up = func(i-1,j,dp);
        int left = func(i,j-1,dp);

        return dp[i][j] = up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         this.obstacleGrid = obstacleGrid;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return func(m-1,n-1,dp);
    }
}