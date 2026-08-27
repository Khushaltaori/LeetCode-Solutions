class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] count = new int[26];

        // Count characters of s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder answer = new StringBuilder();
        int n = s.length();

        // Try to match target from left to right
        int i = 0;

        while (i < n) {
            char ch = target.charAt(i);

            if (count[ch - 'a'] > 0) {
                answer.append(ch);
                count[ch - 'a']--;
                i++;
            } else {
                break;
            }
        }

        // If we got stuck at position i,
        // start checking from i.
        // If we matched everything, start from n - 1.
        int start = Math.min(i, n - 1);

        // Go backward
        for (int j = start; j >= 0; j--) {

            // If this position was already matched,
            // remove and restore it
            if (j < answer.length()) {
                char removed = answer.charAt(j);

                answer.deleteCharAt(j);

                count[removed - 'a']++;
            }

            char targetChar = target.charAt(j);

            // Find smallest character greater than targetChar
            for (char ch = (char) (targetChar + 1); ch <= 'z'; ch++) {

                if (count[ch - 'a'] > 0) {

                    answer.append(ch);
                    count[ch - 'a']--;

                    // Append all remaining characters
                    // in sorted order
                    for (char c = 'a'; c <= 'z'; c++) {

                        while (count[c - 'a'] > 0) {
                            answer.append(c);
                            count[c - 'a']--;
                        }
                    }

                    return answer.toString();
                }
            }
        }

        return "";
    }
}