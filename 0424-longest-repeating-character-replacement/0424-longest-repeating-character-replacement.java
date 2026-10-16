class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int right=0;
        int maxfreq=0;
        int maxlen=0;
        int arr[]=new int[26];
        while(right<s.length()){
            char ch=s.charAt(right);
            arr[ch-'A']++;
            maxfreq=Math.max(arr[ch-'A'],maxfreq);
            if((right-left+1)-maxfreq>k){
                arr[s.charAt(left)-'A']--;
                left=left+1;
            }
            maxlen=Math.max(right-left+1,maxlen);
            right=right+1;
        }
        return maxlen;
    }
}