class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int prev2 = 0;

        for(int i=0;i<n;i++){
            int take = nums[i];
            if(i>1) take += prev2;

            int nontake = 0 + prev;

            int curi = Math.max(take,nontake);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}