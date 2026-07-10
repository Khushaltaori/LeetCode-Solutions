class Solution {

    private boolean canDivide(int[] nums,int threshold,int divisor){
        double sum = 0;
        for(int num:nums){
            sum += Math.ceil((double)num/divisor);
        }

       return sum<= threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        for(int num:nums){
            high = Math.max(high,num);
        }

        while(low<=high){
            int mid = (low+high)/2;

            if(canDivide(nums,threshold,mid)){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}