class Solution {
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        long ans=-1;
        long s=1;
        long e=x;
        while(s<=e){
            long mid=s+(e-s)/2;
            if(mid*mid==x){
                ans=mid;
                break;
            }
            else if(mid*mid>x){
                e=mid-1;
            }
            else{
                ans=mid;
                s=mid+1;
            }
        }
        return (int)ans;
    }
}