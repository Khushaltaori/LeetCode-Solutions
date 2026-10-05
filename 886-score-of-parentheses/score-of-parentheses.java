class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
          int score = 0;
          st.push(0);
        for(char ch: s.toCharArray()){

          
          

            if(ch == '(') st.push(0);

            if(ch == ')'){
                int inside = st.pop();
                if(inside == 0){
                    score = 1;
                    
                }
                else{
                    score = 2 * inside;
                }

                int parent = st.pop();
                st.push(parent+score);
            }
        }
        return st.peek();
    }
}