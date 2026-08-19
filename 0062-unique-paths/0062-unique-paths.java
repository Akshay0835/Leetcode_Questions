class Solution {
    static int solve(int ix,int iy,int m,int n,int dp[][]){
        if(ix>=m|| iy>=n){
            return 0;
        }
        if(ix==m-1&&iy==n-1){
            return 1;
        }
        if(dp[ix][iy]!=-1){
            return dp[ix][iy];
        }
            int right=solve(ix+1,iy,m,n,dp);
            int  down=solve(ix,iy+1,m,n,dp);
        return dp[ix][iy]=right+down;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=solve(0,0,m,n,dp);
        return ans;
    }
}