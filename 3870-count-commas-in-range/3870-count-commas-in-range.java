class Solution {
    public int countCommas(int n) {
        if(n<=999){
            return 0;
        }
        int c=0;
        for(int i=1000;i<=n;i++){
            int j=i;
        while(j>0){
            j=j/1000;
            if(j>0){
                c++;
            }
        }
        }
        return c;
    }
}