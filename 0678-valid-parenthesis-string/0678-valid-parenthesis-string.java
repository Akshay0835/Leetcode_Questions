class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        Stack<Integer> bracket=new Stack<>();
        Stack<Integer> star=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                bracket.push(i);
            }
            else if(ch=='*'){
                star.push(i);
            }
            else{
                if(!bracket.isEmpty()){
                    bracket.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!bracket.isEmpty()&&!star.isEmpty()){
            if(bracket.pop()>star.pop()){
                return false;
            }
        }
        return bracket.isEmpty();
    }
}