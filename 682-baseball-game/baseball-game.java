class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        for(String op : operations){

            if(op.equals("+")){
                int first = st.pop();
                int second = st.peek();

                st.push(first);
                st.push(first+second);
            }else if(op.equals("D")){
                st.push(2*st.peek());

            }else if(op.equals("C")){
                st.pop();
            }else{
                st.push(Integer.parseInt(op));
            }

            
        
        }

        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}