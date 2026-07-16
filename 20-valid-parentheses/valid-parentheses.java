class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            //opening push
            if(s.charAt(i)=='('|| s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }else{
                //closing

                if(st.isEmpty()) return false;
                Character ch = st.peek();

                if(s.charAt(i)==')' && ch == '(' ||
   s.charAt(i)==']' && ch == '[' ||
   s.charAt(i)=='}' && ch == '{'){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}