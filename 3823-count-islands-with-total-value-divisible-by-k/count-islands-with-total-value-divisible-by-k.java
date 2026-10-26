class Solution {
    int m,n;
    public long func(int[][] grid,boolean[][] visited,int row,int col){

        if(row<0 || col<0 || row >= m || col>=n|| grid[row][col]==0 || visited[row][col]){
            return 0;
        }

        visited[row][col] = true;
        long sum = grid[row][col];

        sum += func(grid,visited,row-1,col); //up
        sum += func(grid,visited,row+1,col); //down
        sum += func(grid,visited,row,col+1); //right
        sum += func(grid,visited,row,col-1);  //left

        return sum;
    }
    public int countIslands(int[][] grid, int k) {
         m = grid.length;
         n = grid[0].length;

        int count = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0 && !visited[i][j]){
                    
                    long sum = func(grid,visited,i,j);
                    if(sum % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}