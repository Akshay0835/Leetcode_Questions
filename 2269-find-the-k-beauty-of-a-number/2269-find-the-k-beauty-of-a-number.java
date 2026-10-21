class Solution {
    public int divisorSubstrings(int num, int k) {
        return solve(num, k);
    }

    static int solve(int num, int k) {
        String s = "" + num;
        int right = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        while (right < s.length()) {
            char ch = s.charAt(right);
            sb.append(ch);

            if (sb.length() > k) {
                sb.deleteCharAt(0);
            }

            if (sb.length() == k) {
                int n = Integer.parseInt(sb.toString());

                if (n != 0 && num % n == 0) {
                    count++;
                }
            }

            right++;
        }

        return count;
    }
}