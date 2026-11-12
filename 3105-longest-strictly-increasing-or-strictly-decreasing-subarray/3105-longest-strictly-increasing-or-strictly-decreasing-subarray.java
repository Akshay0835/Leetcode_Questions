class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int leninc=1;
        int lendec=1;
        for(int i=0;i<nums.length;i++){
            int prev=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>prev){
                    prev=nums[j];
                    leninc=Math.max(leninc,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            int prev=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<prev){
                    prev=nums[j];
                    lendec=Math.max(lendec,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return Math.max(leninc,lendec);
    }
}