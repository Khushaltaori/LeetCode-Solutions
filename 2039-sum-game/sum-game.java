class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0;
        int rightSum = 0;
        int leftcount = 0;
        int rightcount = 0;

        int i=0;
        int j = n-1;
        while(i<n/2 && j>=n/2){
            char left = num.charAt(i);
            char right = num.charAt(j);

            if(left != '?'){
                leftSum += left - '0';
            }else{
                leftcount++;
            }

            if(right!= '?'){
                rightSum += right - '0';
            } else{
                rightcount++;
            }

            i++;
            j--;
        }

        if((leftcount + rightcount) % 2 != 0){
            //alice wins
            return true;
        }

        int sumDifference =  rightSum - leftSum;
        int maxDifference = leftcount - rightcount;
        if(sumDifference == (maxDifference)* 9/2){
            //bob wins
            return false;
        }
        return leftSum - rightSum !=
       (rightcount - leftcount) * 9 / 2;
    }
}