class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] nse = new int[n];
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        Arrays.fill(nse,0);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>prices[i]){
                st.pop();
            }

            
            if(st.isEmpty()){
                nse[i]=0;
            }else{
                nse[i] = st.peek();
            }

            st.push(prices[i]);
        }

        for(int i=0;i<n;i++){
            ans[i] = prices[i]-nse[i];
        }
        return ans;
        }
        
        
    }
