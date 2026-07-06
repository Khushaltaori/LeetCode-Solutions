import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        // Add elements of nums1
        for (int num : nums1) {
            list.add(num);
        }

        // Add elements of nums2
        for (int num : nums2) {
            list.add(num);
        }

        // Sort the merged list
        Collections.sort(list);

        int n = list.size();

        // If odd number of elements
        if (n % 2 == 1) {
            return list.get(n / 2);
        }

        // If even number of elements
        return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
    }
}