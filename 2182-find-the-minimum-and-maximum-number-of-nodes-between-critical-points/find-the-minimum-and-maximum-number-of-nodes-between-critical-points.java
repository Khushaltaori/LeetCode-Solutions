class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        ListNode prev = head;
        ListNode temp = head.next;

        int first = -1;
        int last = -1;
        int minDist = Integer.MAX_VALUE;

        int index = 1;

        while (temp.next != null) {

            ListNode next = temp.next;

            // Check for critical point
            if ((temp.val > prev.val && temp.val > next.val) ||
                (temp.val < prev.val && temp.val < next.val)) {

                if (first == -1) {
                    // First critical point
                    first = index;
                } else {
                    // Distance from previous critical point
                    minDist = Math.min(minDist, index - last);
                }

                // Current critical point becomes last
                last = index;
            }

            // Move forward
            prev = temp;
            temp = next;
            index++;
        }

        // Fewer than 2 critical points
        if (first == -1 || first == last) {
            return ans;
        }

        int maxDist = last - first;

        ans[0] = minDist;
        ans[1] = maxDist;

        return ans;
    }
}