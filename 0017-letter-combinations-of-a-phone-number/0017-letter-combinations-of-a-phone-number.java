class Solution {

    List<String> ans = new ArrayList<>();

    String mp[] = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    void solve(String digits, int index, int letterIndex, StringBuilder temp) {

        if (index == digits.length()) {
            ans.add(temp.toString());
            return;
        }

        String letters = mp[digits.charAt(index) - '0'];

        if (letterIndex == letters.length()) {
            return;
        }

        temp.append(letters.charAt(letterIndex));

        solve(digits, index + 1, 0, temp);

        temp.deleteCharAt(temp.length() - 1);

        solve(digits, index, letterIndex + 1, temp);
    }

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        StringBuilder temp = new StringBuilder();

        solve(digits, 0, 0, temp);

        return ans;
    }
}