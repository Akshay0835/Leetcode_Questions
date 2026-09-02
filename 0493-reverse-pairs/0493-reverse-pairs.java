class Solution {
    static int merge(int arr[],int s,int e,int mid){
        int leftlen=mid-s+1;
        int rightlen=e-mid;
        int left[]=new int[leftlen];
        int right[]=new int[rightlen];
        int k=s;
        for(int i=0;i<leftlen;i++){
            left[i]=arr[k];
            k++;
        }
        k=mid+1;
        for(int i=0;i<rightlen;i++){
            right[i]=arr[k];
            k++;
        }
        int i=0,j=0;k=s;

        int count=0;
        j=0;
        for(i=0;i<leftlen;i++){
            while(j<rightlen && (long)left[i] > 2L*right[j]){
                j++;
            }
            count=count+j;
        }
        i=0;
        j=0;
        while(i<leftlen&&j<rightlen){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
                k++;
            }
            else{
                arr[k]=right[j];
                j++;
                k++;
            }
        }
        while(i<leftlen){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<rightlen){
            arr[k]=right[j];
            j++;
            k++;
        }
        return count;
    }
    static int mergesort(int s,int e,int arr[]){
        if(s>e){
            return 0;
        }
        if(s==e){
            return 0;
        }
        int mid=s+(e-s)/2;
        int leftinver=mergesort(s,mid,arr);
        int rightinve=mergesort(mid+1,e,arr);
        int interinver=merge(arr,s,e,mid);
        return leftinver+rightinve+interinver;
    }
    public int reversePairs(int[] nums) {
        int s=0;
        int e=nums.length-1;
        int ans=mergesort(s,e,nums);
        return ans;
    }
}