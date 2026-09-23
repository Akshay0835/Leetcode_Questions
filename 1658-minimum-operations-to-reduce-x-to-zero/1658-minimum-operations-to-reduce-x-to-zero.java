class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int target=sum-x;
        if(target<0){
            return -1;
        }
        if(target==0){
            return nums.length;
        }
        int start=0,end=0,curr=0,max=-1;
        while(end<nums.length){
            curr+=nums[end];
            while(curr>target&&start<=end){
                curr-=nums[start];
                start++;
            }
            if(curr==target){
            max=Math.max(max,end-start+1);
            }
            end++;
        }
        return max==-1 ? -1:nums.length-max;
    }
}