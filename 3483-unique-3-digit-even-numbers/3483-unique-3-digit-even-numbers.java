import java.util.*;

class Solution {

    static void solve(int[] digits, boolean[] used,
                      StringBuilder sb, Set<Integer> set) {

        if (sb.length() == 3) {

            if (sb.charAt(0) != '0') {

                int num = Integer.parseInt(sb.toString());

                if (num % 2 == 0) {
                    set.add(num);
                }
            }

            return;
        }

        for (int i = 0; i < digits.length; i++) {

            if (!used[i]) {

                used[i] = true;

                sb.append(digits[i]);

                solve(digits, used, sb, set);

                sb.deleteCharAt(sb.length() - 1);

                used[i] = false;
            }
        }
    }

    public int totalNumbers(int[] digits) {

        Set<Integer> set = new HashSet<>();

        boolean[] used = new boolean[digits.length];

        solve(digits, used, new StringBuilder(), set);

        return set.size();
    }
}