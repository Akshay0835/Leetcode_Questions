class Solution {

    static void solve(int digits[], StringBuilder s, Set<Integer> set,
                      boolean used[]) {

        if (s.length() == 3) {

            int num = Integer.parseInt(s.toString());

            if (num % 2 == 0) {
                set.add(num);
            }

            return;
        }

        for (int i = 0; i < digits.length; i++) {

            if (used[i]) {
                continue;
            }

            if (s.length() == 0 && digits[i] == 0) {
                continue;
            }

            used[i] = true;

            s.append(digits[i]);

            solve(digits, s, set, used);

            s.deleteCharAt(s.length() - 1);

            used[i] = false;
        }
    }

    public int[] findEvenNumbers(int[] digits) {

        Set<Integer> set = new TreeSet<>();

        StringBuilder s = new StringBuilder();

        boolean used[] = new boolean[digits.length];

        solve(digits, s, set, used);

        int ans[] = new int[set.size()];

        int i = 0;

        for (int num : set) {
            ans[i++] = num;
        }

        return ans;
    }
}