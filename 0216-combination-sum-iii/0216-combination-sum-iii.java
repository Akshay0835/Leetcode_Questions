class Solution {
    static void solve(int index,int arr[],int tar,List<List<Integer>> ans,List<Integer> list,int k){
        if(tar==0&&list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(index==arr.length||tar<0){
            return;
        }
        list.add(arr[index]);
        solve(index+1,arr,tar-arr[index],ans,list,k);
        list.remove(list.size()-1);
        solve(index+1,arr,tar,ans,list,k);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int arr[]=new int[9];
        int j=1;
        for(int i=0;i<9;i++){
            arr[i]=j;
            j++;
        }
        solve(0,arr,n,ans,list,k);
        return ans;
    }
}