class Solution {

    public void func(int[] candidates,int index,int target,List<Integer> list,List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(index == candidates.length){
            return;
        }

        //take
        if(candidates[index]<= target){
            list.add(candidates[index]);
            func(candidates,index,target-candidates[index],list,ans);

            list.remove(list.size()-1);
        }

        //nontake
        func(candidates,index+1,target,list,ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        func(candidates,0,target,list,ans);
        return ans;
    }
}