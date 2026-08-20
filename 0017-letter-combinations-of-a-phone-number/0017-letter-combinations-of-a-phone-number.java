class Solution {
    static String map[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static void solve(String digit,String str,int index,List<String> ans){
        if(index==digit.length()){
            ans.add(str);
            return;
        }
        String letter=map[digit.charAt(index)-'0'];
        for(int i=0;i<letter.length();i++){
            str+=letter.charAt(i);
            solve(digit,str,index+1,ans);
            str=str.substring(0,str.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        solve(digits,"",0,ans);
        return ans;
    }
}