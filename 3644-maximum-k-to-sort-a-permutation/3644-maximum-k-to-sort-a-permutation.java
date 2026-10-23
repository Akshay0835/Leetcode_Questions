class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        int max_k=(int)Math.pow(2,Math.ceil((Math.log(n)/Math.log(2))))-1;
        int k=max_k;
        for(int i=0;i<n;i++){
            if(nums[i]!=i){
                k&=nums[i];
            }
        }
        return k==max_k?0:k;
    }
}