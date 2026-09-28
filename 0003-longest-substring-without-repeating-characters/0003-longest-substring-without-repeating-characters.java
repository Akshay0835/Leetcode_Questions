class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list=new ArrayList<>();
        int left=0;
        int right=0;
        int ans=0;
        while(right<s.length()){
            char ch=s.charAt(right);
            if(list.contains(ch)){
                list.remove(0);
                left++;
            }
            else{
                list.add(ch);
                right++;
                ans=Math.max(ans,list.size());
            }
        }
        return ans;
    }
}