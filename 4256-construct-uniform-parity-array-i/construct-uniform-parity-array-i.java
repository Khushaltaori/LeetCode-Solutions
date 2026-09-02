class Solution {
    public boolean uniformArray(int[] nums1) {
        
        int n = nums1.length;
        for(int i=0;i<n;i++){
            while(nums1[i] % 2 == 0){
                return true;
            }

            while(nums1[i] % 2 == 1){
                return true;
            }
        }
        return false;
    }
}