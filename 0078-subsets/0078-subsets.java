class Solution {
    static void solve(int nums[],List<List<Integer>>ans,int index,List<Integer> list){
        if(index==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        solve(nums,ans,index+1,list);
        list.remove(list.size()-1);
        solve(nums,ans,index+1,list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        solve(nums,ans,0,list);
        return ans;
    }
}