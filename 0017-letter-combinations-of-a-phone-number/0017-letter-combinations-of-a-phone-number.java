class Solution {
    static void solve(String digits,int index,String map[],List<String> ans,StringBuilder output){
        if(index>=digits.length()){
            ans.add(output.toString());
            return;
        }
        int val=digits.charAt(index)-'0';
        String mapped=map[val];
        for(int i=0;i<mapped.length();i++){
            output.append(mapped.charAt(i));
            solve(digits,index+1,map,ans,output);
            output.deleteCharAt(output.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        String map[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans=new ArrayList<>();
        StringBuilder output=new StringBuilder();
        solve(digits,0,map,ans,output);
        return ans;
    }
}