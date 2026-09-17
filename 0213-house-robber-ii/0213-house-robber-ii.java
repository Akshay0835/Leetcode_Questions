class Solution {
    static int solve(int dp[],int arr[],int index){
        if(index>=arr.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int include=arr[index]+solve(dp,arr,index+2);
        int exclude=0+solve(dp,arr,index+1);
        return dp[index]=Math.max(include,exclude);
    }
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int arr1[]=new int[nums.length-1];
        int arr2[]=new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            arr1[i]=nums[i];
        }
        int index=0;
        for(int i=1;i<nums.length;i++){
            arr2[index++]=nums[i];
        }
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int ans1=solve(dp,arr1,0);
        Arrays.fill(dp,-1);
        int ans2=solve(dp,arr2,0);
        return Math.max(ans1,ans2);
    }
}