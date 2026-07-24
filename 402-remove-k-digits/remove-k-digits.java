class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(char ch:num.toCharArray()){
            while(!st.isEmpty() && k>0 && ch<st.peek()){
                st.pop();
                k--;
            }

            st.push(ch);
        }
            while(!st.isEmpty() && k>0){
                st.pop();
                k--;
            }

            
            StringBuilder ans = new StringBuilder();
            //trailing zeroes
            while(!st.isEmpty()){
                ans.append(st.pop());
            }

            ans.reverse();

            while(ans.length()>0 && ans.charAt(0)=='0'){
                ans.deleteCharAt(0);
            }

            if(ans.length()==0){
                return "0";
            }else{
                return ans.toString();
            }

        }
        
}