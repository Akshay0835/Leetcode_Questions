class Solution {
    public String minWindow(String s, String t) {
        int arr[]=new int[256];
        int n=s.length();
        int m=t.length();
        for(char ch:t.toCharArray()){
            arr[ch]++;
        }
        int c=0;
        int left=0,right=0;
        int minlen=Integer.MAX_VALUE;
        int sindex=-1;
        while(right<n){
            char ch=s.charAt(right);
            if(arr[ch]>0){
                c++;
            }
            arr[ch]--;
            while(c==m){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    sindex=left;
                }
                arr[s.charAt(left)]++;
                if(arr[s.charAt(left)]>0){
                    c--;
                }
                left++;
            }
            right++;
        }
        return sindex==-1?"":s.substring(sindex,sindex+minlen);
    }
}