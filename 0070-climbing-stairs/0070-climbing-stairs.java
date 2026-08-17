class Solution {
    static int solve(int n,int dp[]){
        if(dp[n]!=-1){
            return dp[n];
        }
        if(n<=2){
            return dp[n]=n;
        }
        dp[n]=solve(n-1,dp)+solve(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int ans=solve(n,dp);
        return ans;
    }
}