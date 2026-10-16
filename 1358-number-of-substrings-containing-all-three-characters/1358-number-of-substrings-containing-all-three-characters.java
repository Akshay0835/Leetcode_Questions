class Solution {
    public int numberOfSubstrings(String s) {
        int arr[]=new int[3];
        Arrays.fill(arr,-1);
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            arr[ch-'a']=i;
            if(arr[0]!=-1&&arr[1]!=-1&&arr[2]!=-1){
                ans+=(1+Math.min(arr[0],Math.min(arr[1],arr[2])));
            }
        }
        return ans;
    }
}