class Solution {

    public void func(int[]nums,int index,List<Integer>list,List<List<Integer>> ans){

        if(index==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        //take
        list.add(nums[index]);
        func(nums,index+1,list,ans);

        //non take
        list.remove(list.size()-1);
        func(nums,index+1,list,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n= nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        func(nums,0,list,ans);
        return ans;
    }
}