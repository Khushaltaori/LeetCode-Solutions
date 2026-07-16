class Pair {
    int val;
    int min;

    Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}


class MinStack {

    Stack<Pair> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push(new Pair(value,value));
        }else{
            st.push(new Pair(value,Math.min(value,st.peek().min)));
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */