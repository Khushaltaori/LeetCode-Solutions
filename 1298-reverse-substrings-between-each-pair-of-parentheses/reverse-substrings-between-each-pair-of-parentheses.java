import java.util.*;

class Solution {

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);

            left++;
            right--;
        }
    }

    public String reverseParentheses(String s) {

        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {

            if (sb.charAt(i) == '(') {
                stack.push(i);
            }

            else if (sb.charAt(i) == ')') {

                int left = stack.pop();

                // Reverse characters inside parentheses
                reverse(sb, left + 1, i - 1);
            }
        }

        // Remove parentheses
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '(' && sb.charAt(i) != ')') {
                ans.append(sb.charAt(i));
            }
        }

        return ans.toString();
    }
}