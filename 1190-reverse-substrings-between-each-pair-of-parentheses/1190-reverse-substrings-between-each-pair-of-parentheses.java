class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st=new Stack<>();
        String current="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(current);
                current="";
            }
            else if(ch==')'){
                StringBuilder sb=new StringBuilder(current);
                current=sb.reverse().toString();
                current=st.pop()+current;
            }
            else{
                current+=ch;
            }
        }
        return current;
    }
}