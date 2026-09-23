class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        // Find total sum
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        // If target < 0, impossible
        if (target < 0) {
            return -1;
        }

        // Find longest subarray with sum = target
        int left = 0;
        int sum = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        // No such subarray
        if (maxLen == -1) {
            return -1;
        }

        return n - maxLen;
    }
}