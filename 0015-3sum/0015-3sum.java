class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length - 1; i++){

            if(i > 0 && nums[i] == nums[i-1])
                continue;

            int first = i + 1;
            int last = nums.length - 1;
            int tar = 0 - nums[i];

            while(first < last){
                int curr = nums[first] + nums[last];

                if(curr == tar){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[first]);
                    list.add(nums[last]);
                    ans.add(list);

                    int x = nums[first];
                    int y = nums[last];

                    while(first < last && nums[first] == x)
                        first++;

                    while(first < last && nums[last] == y)
                        last--;
                }
                else if(curr < tar){
                    first++;
                }
                else{
                    last--;
                }
            }
        }

        return ans;
    }
}