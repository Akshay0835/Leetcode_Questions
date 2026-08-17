class Solution {
    static int solve(int arr[],int index,int dp[]){
        if(index>=arr.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int include=arr[index]+solve(arr,index+2,dp);
        int exclude=0+solve(arr,index+1,dp);
        return dp[index]=Math.max(include,exclude);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int ans=solve(nums,0,dp);
        return ans;
    }
}