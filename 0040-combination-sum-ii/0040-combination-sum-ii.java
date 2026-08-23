class Solution {
    static void solve(int index,int arr[],int tar,List<List<Integer>> ans,List<Integer> list){
        if(tar==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(index==arr.length||tar<0){
            return;
        }
        list.add(arr[index]);
        solve(index+1,arr,tar-arr[index],ans,list);
        list.remove(list.size()-1);
        while(index+1<arr.length&&arr[index]==arr[index+1]){
            index++;
        }
        solve(index+1,arr,tar,ans,list);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,candidates,target,ans,list);
        return ans;
    }
}