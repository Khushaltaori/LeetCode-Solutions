import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        long sum = 0;

        for (int i = n / 2; i < n; i++) {
            sum += (long) arr[i] * arr[i];
        }

        for (int i = 0; i < n / 2; i++) {
            sum -= (long) arr[i] * arr[i];
        }

        return sum;
    }
}