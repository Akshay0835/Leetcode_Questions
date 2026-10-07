class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a'){
                st.push(ch);
            }
            else if(ch=='b'){
                st.push(ch);
            }
            else if(ch=='c'){
                if(st.size()>=2){
                char top1=st.peek();
                st.pop();
                char top2=st.peek();
                st.pop();
                
                if(top1!='b'||top2!='a'){
                    return false;
                }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return st.size()==0;
    }
}