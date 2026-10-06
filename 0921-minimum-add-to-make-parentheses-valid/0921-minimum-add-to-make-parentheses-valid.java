class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int c=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(i);
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    c++;
                }
            }
        }
        return st.size()+c;
    }
}