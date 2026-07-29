import java.util.*;

class Solution {

    public int[] findNSE(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public int[] findPSE(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);

        int maxA = 0;

        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxA = Math.max(maxA, area);
        }

        return maxA;
    }
}