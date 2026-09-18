class Solution {

    public String reverseStr(String s, int k) {

        String ans = "";

        for (int i = 0; i < s.length(); i += 2 * k) {

            int end = Math.min(i + k, s.length());

            String sub = s.substring(i, end);

            String rev = new StringBuilder(sub).reverse().toString();

            ans += rev;

            if (i + k < s.length()) {
                ans += s.substring(i + k, Math.min(i + 2 * k, s.length()));
            }
        }

        return ans;
    }
}