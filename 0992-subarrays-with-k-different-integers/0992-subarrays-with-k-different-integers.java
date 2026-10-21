class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
    static int solve(int arr[],int k){
        int left=0;
        int right=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        while(right<arr.length){
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            while(map.size()>k){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }
}