class Solution {
    static void solve(String s,Set<String> set,String sentence,List<String> ans,int index){
        if(index==s.length()){
            ans.add(sentence.trim());
            return;
        }
        for(int i=index+1;i<=s.length();i++){
            String sub=s.substring(index,i);
            if(set.contains(sub)){
                solve(s,set,sentence+sub+" ",ans,i);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        List<String> ans=new ArrayList<>();
        solve(s,set,"",ans,0);
        return ans;
    }
}