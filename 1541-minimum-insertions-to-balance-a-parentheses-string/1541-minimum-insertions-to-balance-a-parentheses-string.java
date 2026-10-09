class Solution {
    public int minInsertions(String s) {
        Deque<String> st=new ArrayDeque<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch+"");
            }
            else{
                if(i+1<s.length()&&s.charAt(i+1)==')'){
                    i++;
                }
                else{
                    ans++;
                }
                if(!st.isEmpty()&&st.peek().equals("(")){
                    st.pop();
                }
                else{
                    ans++;
                }
            }
        }

        return ans+st.size()*2;
    }
}