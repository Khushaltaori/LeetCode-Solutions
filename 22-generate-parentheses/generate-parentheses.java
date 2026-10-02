class Solution {

    public void func(int open,int close ,String str , List<String> ans){
        //valid open and close

        if(open == 0 && close == 0) {
            ans.add(str);
            return;
        }

        //take ( 
        if(open>0){
            func(open-1,close,str+"(" , ans);
        }

        //close
        if(close>open){
            func(open,close-1,str+")" , ans);
        }

        
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
         func(n,n,"",ans);
        return ans;
    }
}