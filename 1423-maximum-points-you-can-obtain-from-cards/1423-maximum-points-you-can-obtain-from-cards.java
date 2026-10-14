class Solution {
    public int maxScore(int[] cardPoints, int k) {
       int leftsum=0;
       int rightsum=0;
       int max=0;
       for(int i=0;i<k;i++){
        leftsum+=cardPoints[i];
       }
       max=leftsum;
       int left=k-1;
       int right=cardPoints.length-1;
       while(left>=0){
        leftsum-=cardPoints[left];
        rightsum+=cardPoints[right];
        left--;
        right--;
        max=Math.max(max,leftsum+rightsum);
       }
       return max;
    }
}