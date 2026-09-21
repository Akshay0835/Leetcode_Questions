class Solution {
    public long[] resultArray(int[] nums, int k) {
        long ans[]=new long[k];
        long dp[]=new long[k];
        for(int i=0;i<nums.length;i++){
            long next[]=new long[k];
            int val=nums[i]%k;
            next[val]++;
            for(int r=0;r<k;r++){
                if(dp[r]>0){
                    int newval=(r*val)%k;
                    next[newval]+=dp[r];
                }
            }
            for(int r=0;r<k;r++){
                ans[r]+=next[r];
            }
            dp=next;
        }
        return ans;
    }
}