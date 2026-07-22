class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int x : asteroids) {

            if (x > 0) {
                st.push(x);
            } else {

                while (!st.isEmpty()
                        && st.peek() > 0
                        && st.peek() < Math.abs(x)) {
                    st.pop();
                }

                if (!st.isEmpty()
                        && st.peek() == Math.abs(x)) {
                    st.pop();
                }
                else if (st.isEmpty()
                        || st.peek() < 0) {
                    st.push(x);
                }
            }
        }

        int[] ans = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}