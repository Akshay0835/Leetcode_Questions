class Solution {
    static int solve(int nums[],int index,int dp[],int len){
        if(index>=nums.length){
            return len;
        }
        for(int i=0;i<index;i++){
            if(nums[index]>nums[i]){
                dp[index]=Math.max(dp[index],dp[i]+1);
            }
        }
        len=Math.max(len,dp[index]);
        len=solve(nums,index+1,dp,len);
        return len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int len=1;
        int ans=solve(nums,0,dp,len);
        return ans;
    }
}