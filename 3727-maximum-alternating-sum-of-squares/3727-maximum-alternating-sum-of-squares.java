class Solution {
    public long maxAlternatingSum(int[] nums) {
        long arr[]=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=(long)(nums[i]*nums[i]);
        }
        long ans=0;
        int n=nums.length;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(i<n/2){
                ans-=arr[i];
            }
            else{
                ans+=arr[i];
            }
        }
        return ans;
    }
}