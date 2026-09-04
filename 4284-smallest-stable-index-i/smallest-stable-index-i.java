class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int maxV = Integer.MIN_VALUE;

            for(int j=0;j<=i;j++){
                maxV = Math.max(maxV,nums[j]);
            }

            int minV = Integer.MAX_VALUE;

            for(int j=i;j<n;j++){
                minV = Math.min(minV,nums[j]);
            }

            if(maxV - minV <= k){
                return i;
            }
        }
        return -1;
    }
}