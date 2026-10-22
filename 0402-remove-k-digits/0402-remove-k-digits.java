class Solution {
    public String removeKdigits(String num, int k) {
        int count=0;
        Deque<Character> st=new ArrayDeque<>();
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            while(!st.isEmpty()&&count<k&&ch<st.peek()){
                st.pop();
                count++;
            }
            st.push(ch);
        }
        while (count < k && !st.isEmpty()) {
            st.pop();
            count++;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        int index=0;
        while(index<sb.length()&&sb.charAt(index)=='0'){
            index++;
        }
        String ans=sb.substring(index);
        return ans==""?"0":ans;
    }
}