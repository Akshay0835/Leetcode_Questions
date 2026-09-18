class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        StringBuilder sb=new StringBuilder();
        String s1=strs[0];
        String s2=strs[1];
        for(int i=0;i<Math.min(s1.length(),s2.length());i++){
            if(s1.charAt(i)==s2.charAt(i)){
                sb.append(s1.charAt(i));
            }
            else{
                break;
            }
        }
        for(int i=2;i<strs.length;i++){
            int index=0;
            int len=Math.min(sb.length(),strs[i].length());
            while(index<len&&sb.charAt(index)==strs[i].charAt(index)){
                index++;
            }
            sb.setLength(index);
        }
        return sb.toString();
    }
}