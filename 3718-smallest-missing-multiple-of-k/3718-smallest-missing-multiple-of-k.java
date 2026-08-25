class Solution {
    public int missingMultiple(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        int ans=0;
        for(int i=k;i>0;i+=k){
            if(!list.contains(i)){
                ans=i;
                break;
            }
        }
        return ans;
    }
}