class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];

        //skip first house
        int case1 = robRange(nums,1,n-1);

        //skip last house
        int case2 = robRange(nums,0,n-2);

        return Math.max(case1,case2);
    }

    public int robRange(int[] nums , int start,int end) {
        int n = nums.length;
        int prev = 0;
        int prev2 = 0;

        for(int i=start;i<=end;i++){
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