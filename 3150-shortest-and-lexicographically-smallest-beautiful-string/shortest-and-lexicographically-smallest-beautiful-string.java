class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
     int n = s.length();
     int left =0;
     int right = 0;
     int countones = 0;
    String ans = "";
     while(right<n){
        if(s.charAt(right)=='1'){
            countones++;
        }
        right++;

        while(countones>k){
            if(s.charAt(left)=='1'){
                countones--;
            }
            left++;
        }

        if(countones == k){
            while(s.charAt(left)=='0'){
                left++;
            }

            String curr = s.substring(left,right);

            if(ans.equals("")|| curr.length()<ans.length() || curr.length()==ans.length() && curr.compareTo(ans)<0){
            ans = curr;
            }
        }

        
     }   
     return ans;
    }
}