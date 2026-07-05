class Solution {

    private int firstOcc(int[] nums, int target){
        int first = -1;
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                first = mid;
                high = mid-1;
            }else if(nums[mid]<target){
                low = mid + 1;
            }else{
                high = mid-1;
            }

        }
        return first;
    }

    private int secondOcc(int[] nums, int target){
        int second = -1;
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                second = mid;
                low = mid+1;
            }else if(nums[mid]<target){
                low = mid + 1;
            }else{
                high = mid-1;
            }

        }
        return second;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = firstOcc(nums,target);

        if(first == -1) return new int[]{-1,-1};

        int last = secondOcc(nums,target);
        return new int[]{first,last};
    }
}