class Solution {
    public boolean checkDivisibility(int n) {
        int p=1;
        int s=0;
        int temp=n;
        while(n>0){
            int d=n%10;
            s+=d;
            p*=d;
            n/=10;
        }
        return temp%(p+s)==0;
    }
}