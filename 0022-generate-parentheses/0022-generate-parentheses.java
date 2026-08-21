class Solution {
    static void solve(List<String> ans,int left,int right,String s,int n){
        if(s.length()==n*2){
            ans.add(s);
            return;
        }
        if(left<n){
            solve(ans,left+1,right,s+"(",n);
        }
        if(right<left){
            solve(ans,left,right+1,s+")",n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        solve(ans,0,0,"",n);
        return ans;
    }
}