class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i]%2;
        }
        return solve(k,arr)-solve(k-1,arr);
    }
    static int solve(int k,int arr[]){
        int left=0;
        int right=0;
        int sum=0;
        int count=0;
        while(right<arr.length){
            sum+=arr[right];
            while(sum>k){
                sum-=arr[left];
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }
}