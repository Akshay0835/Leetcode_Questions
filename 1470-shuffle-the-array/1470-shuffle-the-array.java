class Solution {
    public int[] shuffle(int[] nums, int n) {
        int mid=nums.length/2;
        int ans[]=new int[nums.length];
        int s=0;
        int ms=mid;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                ans[i]=nums[s++];
            }
            else{
                ans[i]=nums[ms++];
            }
        }
        return ans;
    }
}