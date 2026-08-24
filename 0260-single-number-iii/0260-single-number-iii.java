class Solution {

    public int[] singleNumber(int[] nums) {
        int ans = 0;
        int a[] = new int[2];
        for(int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        int bit = ans & -ans;
        int x = 0;
        int y = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & bit) != 0) {
                x = x ^ nums[i];
            } else {
                y = y ^ nums[i];
            }
        }
        a[0] = x;
        a[1] = y;
        return a;
    }
}