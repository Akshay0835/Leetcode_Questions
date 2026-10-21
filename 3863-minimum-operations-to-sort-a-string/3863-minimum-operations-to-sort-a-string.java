class Solution {
    public int minOperations(String s) {
        boolean sort=true;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)<s.charAt(i-1)){
                sort=false;
                break;
            }
        }
        if(sort){
            return 0;
        }
        if(s.length()==2){
            return -1;
        }
        char min='z';
        char max='a';
        for(char ch:s.toCharArray()){
            min=(char)Math.min(ch,min);
            max=(char)Math.max(ch,max);
        }
        if(s.charAt(0)==min||s.charAt(s.length()-1)==max){
            return 1;
        }
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)==min||s.charAt(i)==max){
                return 2;
            }
        }
        return 3;
    }
}