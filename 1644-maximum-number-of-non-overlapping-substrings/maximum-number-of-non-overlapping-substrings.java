class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        // Step 1: Find first and last occurrence
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {

            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {
                first[c] = i;
            }

            last[c] = i;
        }

        // Step 2: Generate all valid intervals
        List<int[]> intervals = new ArrayList<>();

        for (int c = 0; c < 26; c++) {

            // Character doesn't exist
            if (first[c] == -1) {
                continue;
            }

            int start = first[c];
            int end = last[c];

            boolean valid = true;

            // Expand/check the interval
            for (int i = start; i <= end; i++) {

                int curr = s.charAt(i) - 'a';

                // This character has an occurrence
                // before our starting point
                if (first[curr] < start) {
                    valid = false;
                    break;
                }

                // This character occurs later,
                // so expand our interval
                end = Math.max(end, last[curr]);
            }

            if (valid) {
                intervals.add(new int[]{start, end});
            }
        }

        // Step 3: Sort intervals by ending position
        intervals.sort((a, b) -> a[1] - b[1]);

        // Step 4: Greedy selection
        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for (int[] interval : intervals) {

            int start = interval[0];
            int end = interval[1];

            // Non-overlapping
            if (start > prevEnd) {

                ans.add(s.substring(start, end + 1));

                prevEnd = end;
            }
        }

        return ans;
    }
}