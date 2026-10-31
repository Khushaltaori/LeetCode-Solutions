class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }

                if (i == m - 1 && j == n - 1) {
                    continue;
                }

                // Try moving right
                if (j + 1 < n) {
                    int r = i;
                    int c = j + 1;
                    int dir = 0; // 0 = moving right

                    while (r < m && c < n && grid[r][c] == 1) {
                        if (dir == 0) {
                            r++;
                            dir = 1;
                        } else {
                            c++;
                            dir = 0;
                        }
                    }

                    if (r < m && c < n) {
                        dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                    }
                }

                // Try moving down
                if (i + 1 < m) {
                    int r = i + 1;
                    int c = j;
                    int dir = 1; // 1 = moving down

                    while (r < m && c < n && grid[r][c] == 1) {
                        if (dir == 0) {
                            r++;
                            dir = 1;
                        } else {
                            c++;
                            dir = 0;
                        }
                    }

                    if (r < m && c < n) {
                        dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                    }
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}