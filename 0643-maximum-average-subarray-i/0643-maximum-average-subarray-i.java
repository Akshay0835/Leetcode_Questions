class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans=0;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        ans=(double)sum/k;
        for(int j=k;j<nums.length;j++){
            sum=sum-nums[j-k]+nums[j];
            double avg=(double)sum/k;
            ans=Math.max(avg,ans);
        }
        return ans;
    }
}