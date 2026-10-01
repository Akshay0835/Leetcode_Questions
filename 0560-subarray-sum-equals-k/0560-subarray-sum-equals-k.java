class Solution {
    static int solve(int nums[],int k,int index){
       int count=0;
       int sum=0;
       for(int i=index;i<nums.length;i++){
        sum+=nums[i];
        if(sum==k){
            count++;
        }
       }
       return count;
    }
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=solve(nums,k,i);
        }
        return ans;
    }
}