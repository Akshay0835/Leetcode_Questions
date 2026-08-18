class Solution {
    static int solve(String s, int index, int dp[]) {
        if(index >= s.length()) {
            return 1;
        }

        if(s.charAt(index) == '0') {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        char ch1 = s.charAt(index);
        int single = solve(s, index + 1, dp);
        int doubl = 0;

        if(index + 1 < s.length()) {
            char ch2 = s.charAt(index + 1);
            String a = "" + ch1 + ch2;

            if(Integer.parseInt(a) <= 26) {
                doubl = solve(s, index + 2, dp);
            }
        }

        return dp[index] = single + doubl;
    }

    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }

        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        int ans = solve(s, 0, dp);
        return ans;
    }
}