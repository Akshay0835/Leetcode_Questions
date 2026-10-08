class Solution {
    public int longestValidParentheses(String s) {
        int open=0;
        int close=0;
        int ans1=0,ans2=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                open++;
            }
            else{
                close++;
            }
            if(close>open){
                open=0;
                close=0;
            }
            else if(open==close){
                ans1=Math.max(ans1,2*close);
            }
        }
        open =0;
        close=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='('){
                open++;
            }
            else{
                close++;
            }
            if(open>close){
                open=0;
                close=0;
            }
            else if(open==close){
                ans2=Math.max(ans2,2*close);
            }
        }
        return Math.max(ans1,ans2);
    }
}