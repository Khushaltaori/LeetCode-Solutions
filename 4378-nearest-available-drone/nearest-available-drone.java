class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int n = drones.length;
        int ans = -1;
        int minDistance = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int x = drones[i][0];
            int y = drones[i][1];
            int range = drones[i][2];

            int distance = Math.abs(x-target[0]) + Math.abs(y-target[1]);

            if(distance <= range && distance < minDistance){
                minDistance = distance;
                ans = i;
            }
        }
        return ans;
    }
}