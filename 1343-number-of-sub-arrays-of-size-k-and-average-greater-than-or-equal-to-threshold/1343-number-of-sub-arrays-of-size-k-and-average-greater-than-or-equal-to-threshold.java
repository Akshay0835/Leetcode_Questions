class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int avg=0;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        avg=sum/k;
        int count=0;
        if(avg>=threshold){
            count=1;
        }
        for(int j=k;j<arr.length;j++){
            sum=sum-arr[j-k]+arr[j];
            avg=sum/k;
            if(avg>=threshold){
                count++;
            }
        }
        return count;
    }
}