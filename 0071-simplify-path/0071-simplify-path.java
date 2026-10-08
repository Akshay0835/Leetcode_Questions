class Solution {
    public String simplifyPath(String path) {
        Deque<String> st=new ArrayDeque<>();
        String arr[]=path.split("/");
        for(String ch: arr){
            if(ch.equals("")){
                continue;
            }
            else if(ch.equals(".")){
                continue;
            }
            else if(ch.equals("..")&&st.isEmpty()){
                continue;
            }
            else if(ch.equals("..")&&!st.isEmpty()){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        if(st.isEmpty()){
            return "/";
        }
        else{
            StringBuilder sb=new StringBuilder();
            while(!st.isEmpty()){
                sb.append("/");
                sb.append(st.removeLast());
            }
            return sb.toString();
        }
    }
}