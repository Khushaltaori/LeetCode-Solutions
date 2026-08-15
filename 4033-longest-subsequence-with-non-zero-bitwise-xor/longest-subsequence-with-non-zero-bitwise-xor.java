class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        
        int totalXOR = 0;
        boolean hasNonZero = false;
        for(int i=0;i<n;i++){
            totalXOR ^= nums[i];

            if(nums[i]!=0){
                hasNonZero = true;
            }
        }

        if(totalXOR!=0){
            return n;
        }else if(hasNonZero){
            return n-1;
        }else{
            return 0;
        }
    }
}