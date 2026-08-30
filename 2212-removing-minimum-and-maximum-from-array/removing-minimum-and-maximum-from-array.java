class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int ans = 0;

        int minIndex = 0;
        int maxIndex = 0;

        for(int i=0;i<n;i++){
            if(nums[i]>nums[maxIndex]){
                maxIndex = i;
            }

            if(nums[i]<nums[minIndex]){
                minIndex = i;
            }
        }

        int left = Math.min(minIndex,maxIndex);
        int right = Math.max(minIndex,maxIndex);

        //from front
        int front = right+1;

        //from back
        int back = n - left;

        //1 from front and 1 from back
        int both = (left+1) + (n-right);

        return Math.min(front,Math.min(back,both));

    }
}