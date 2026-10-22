class Solution {
    public int shortestSubarray(int[] nums, int k) {
       TreeMap<Long,Integer> map=new TreeMap<>();
       map.put(0L,0);
       long sum=0;
       int ans=Integer.MAX_VALUE;
       for(int right=1;right<=nums.length;right++){
        sum+=nums[right-1];
        while(!map.isEmpty()){
            Long x=map.floorKey(sum-k);
            if(x==null) break;
            int left=map.get(x);
            ans=Math.min(ans,right-left);
            map.remove(x);
        }
        map.put(sum,right);
       }
       return ans==Integer.MAX_VALUE?-1:ans;
    }
}