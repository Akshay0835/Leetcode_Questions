class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
       Set<Integer> set=new TreeSet<>();
       for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
       }
       ArrayList<Integer> ans=new ArrayList<>(set);
       int n=ans.size();
       if(n>=3){
        return ans.get(n-3);
       }
       else{
        return ans.get(n-1);
       }
    }
}