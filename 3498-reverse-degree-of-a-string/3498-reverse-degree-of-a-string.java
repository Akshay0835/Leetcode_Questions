class Solution {
    public int reverseDegree(String s) {
        String alpha="abcdefghijklmnopqrstuvwxyz";
        int arr[]=new int[26];
        int val=26;
        for(int i=0;i<26;i++){
            char ch=alpha.charAt(i);
            int index=ch-'a';
            arr[index]=val--;
        }
        int ans=0;
        int index=1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int v=ch-'a';
            ans+=(index*arr[v]);
            index++;
        }
        return ans;
    }
}