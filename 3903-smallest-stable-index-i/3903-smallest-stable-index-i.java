class Solution {
    static int minimum(int i,int j,int nums[]){
        int min=Integer.MAX_VALUE;
        int index=0;
        for(int z=i;z<=j;z++){
            if(nums[z]<min){
                index=z;
                min=nums[z];
            }
        }
        return index;
    }
    public int firstStableIndex(int[] nums, int k) {
        int c=-1;
        int minindex=minimum(1,nums.length-1,nums);
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            if(i>minindex){
                minindex=minimum(i,nums.length-1,nums);
            }
            int score=max-nums[minindex];
            if(score<=k){
                c=i;
                break;
            }
        }
        if(c==-1){
            return -1;
        }
        return c;
    }
}