class Solution {
    static int solve(int arr[],int left,int right,int dp[][]){
        if(left+1==right){
            return dp[left][right]=0;
        }
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        int ans=Integer.MIN_VALUE;
        for(int k=left+1;k<right;k++){
            int coins=solve(arr,left,k,dp)+solve(arr,k,right,dp)+arr[left]*arr[k]*arr[right];
            ans=Math.max(ans,coins);
        }
        return dp[left][right]=ans;
    }
    public int maxCoins(int[] nums) {
       int n=nums.length;
       int dp[][]=new int[n+3][n+3];
       for(int i=0;i<=n+2;i++){
        Arrays.fill(dp[i],-1);
       }
       int arr[]=new int[n+2];
       arr[0]=1;
       arr[n+1]=1;
       for(int i=0;i<n;i++){
        arr[i+1]=nums[i];
       }
       int ans=solve(arr,0,n+1,dp);
       return ans;
    }
}