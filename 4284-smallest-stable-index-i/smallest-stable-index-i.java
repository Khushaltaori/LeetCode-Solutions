class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<=i;j++){
                max = Math.max(max,nums[j]);
            }

            int mini = Integer.MAX_VALUE;
            for(int j = i;j<n;j++){
                mini = Math.min(mini,nums[j]);
            }

            if(max-mini<=k){
                return i;
            }
        }
        return -1;
    }
}