class Solution {
    public String removeKdigits(String num, int k) {
        int count=0;
        Deque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            int val=ch-'0';
            while(!st.isEmpty()&&count<k&&val<st.peek()){
                st.pop();
                count++;
            }
            st.push(val);
        }
        while (count < k && !st.isEmpty()) {
            st.pop();
            count++;
        }
        Deque<Integer> ans=new ArrayDeque<>();
        while(!st.isEmpty()){
            ans.push(st.pop());
        }
        String a="";
        while(!ans.isEmpty()){
            if(a.equals("")&&ans.peek()==0){
                ans.pop();
            }else{
            a+=ans.pop();
            }
        }
        if(a==""){
            a+=0;
        }
        return a;
    }
}