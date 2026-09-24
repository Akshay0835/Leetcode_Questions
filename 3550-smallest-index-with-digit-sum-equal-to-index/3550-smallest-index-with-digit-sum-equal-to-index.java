class Solution {
    static boolean solve(int n,int index){
        int sum=0;
        int temp=n;
        while(temp>0){
            int d=temp%10;
            sum+=d;
            temp/=10;
        }
        return sum==index;
    }
    public int smallestIndex(int[] nums) {
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            if(solve(nums[i],i)){
                ans=i;
                break;
            }
        }
        return ans;
    }
}