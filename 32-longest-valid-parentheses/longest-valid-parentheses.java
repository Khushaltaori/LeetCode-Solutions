class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        st.push(-1); // base index

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                // Store index of '('
                st.push(i);
            } 
            else {
                // Remove matching '('
                st.pop();

                if (st.isEmpty()) {
                    // Current ')' is unmatched
                    st.push(i);
                } 
                else {
                    // Valid substring length
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }

        return maxLen;
    }
}