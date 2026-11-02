class Solution {
    public int minMoves2(int[] nums) {
        int l=nums.length;
        if(l==1){
            return 0;
        }
        Arrays.sort(nums);
        int ans=0;
        int mid=nums[l/2];
        for(int i: nums){
            ans+=Math.abs(i-mid);
        }
        return ans;
    }
}