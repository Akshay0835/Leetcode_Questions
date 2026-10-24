class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arr[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int a1=convert(arriveAlice,arr);
        int b1=convert(arriveBob,arr);
        int a2=convert(leaveAlice,arr);
        int b2=convert(leaveBob,arr);

        int start=Math.max(a1,b1);
        int end=Math.min(a2,b2);
        
        return Math.max(0,end-start+1);
    }
    static int convert(String s,int arr[]){
        int month=Integer.parseInt(s.substring(0,2));
        int days=Integer.parseInt(s.substring(3,5));
        int ans=days;
        for(int i=0;i<month-1;i++){
            ans+=arr[i];
        }
        return ans;
    }
}