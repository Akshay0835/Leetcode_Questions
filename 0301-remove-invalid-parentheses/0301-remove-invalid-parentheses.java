class Solution {
    static List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        ans.clear();

        int left = 0;
        int right = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                left++;
            }
            else if(ch == ')') {
                if(left > 0) {
                    left--;
                }
                else {
                    right++;
                }
            }
        }

        solve(s, left, right, 0, 0, "");

        return ans;
    }

    static void solve(String s, int left, int right,
                      int index, int balance, String curr) {

        if(balance < 0) {
            return;
        }

        if(index == s.length()) {
            if(left == 0 && right == 0 && balance == 0) {
                if(!ans.contains(curr)) {
                    ans.add(curr);
                }
            }
            return;
        }

        char ch = s.charAt(index);

        if(ch == '(') {
            if(left > 0) {
                solve(s, left - 1, right,
                      index + 1, balance, curr);
            }
            solve(s, left, right,
                  index + 1, balance + 1, curr + ch);
        }

        else if(ch == ')') {


            if(right > 0) {
                solve(s, left, right - 1,
                      index + 1, balance, curr);
            }
            if(balance > 0) {
                solve(s, left, right,
                      index + 1, balance - 1, curr + ch);
            }
        }

        else {
            solve(s, left, right,
                  index + 1, balance, curr + ch);
        }
    }
}