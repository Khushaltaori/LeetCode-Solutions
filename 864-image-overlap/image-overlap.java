class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        Set<String> ones = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img2[i][j]==1){
                    ones.add(i+","+j);
                }
            }
        }

        int maxOverLap = 0;
        for(int rowShift = -(n-1); rowShift <= n-1; rowShift++){
            for(int colShift = -(n-1) ; colShift <= n-1 ; colShift++){
                int overlap = 0;

                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(img1[i][j]==1){
                            int newRow = i + rowShift;
                            int newCol = j + colShift;

                            if(ones.contains(newRow + "," + newCol)){
                                overlap++;
                            }
                        }
                    }
                }

                maxOverLap = Math.max(maxOverLap,overlap);
            }
        }
        return maxOverLap;
    }
}