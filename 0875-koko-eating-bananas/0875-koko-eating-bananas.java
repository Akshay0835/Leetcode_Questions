class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int i:piles){
            max=Math.max(i,max);
        }
        int low=1;
        int high=max;
        while(low<high){
            int mid=low+(high-low)/2;
            if(valid(piles,mid,h)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    static boolean valid(int[] piles,int mid, int h){
        long ans=0;
        for(int i:piles){
            ans+=(long)(i/mid);
            if(i%mid!=0){
                ans++;
            }
        }
        return ans<=h?true:false;
    }
}