class Solution {

    public int hammingDistance(int x, int y) {
        int max = Math.max(x, y);
        int ans = 0;
        int i = 0;
        while (max > 0) {
            if ((x & 1) != (y & 1)) {
                ans++;
            }
            x = x >> 1;
            y = y >> 1;
            max = max >> 1;
            i++;
        }
        return ans;
    }
}