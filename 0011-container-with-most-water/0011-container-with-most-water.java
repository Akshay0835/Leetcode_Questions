class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int area=Integer.MIN_VALUE;
        while(left<right){
            int breath=right-left;
            int minheight=Math.min(height[left],height[right]);
            int areacov=breath*minheight;
            area=Math.max(areacov,area);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return area;
    }
}