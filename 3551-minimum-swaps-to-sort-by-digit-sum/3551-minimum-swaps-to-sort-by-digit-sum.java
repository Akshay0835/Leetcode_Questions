import java.util.*;

class Solution {

    public int minSwaps(int[] nums) {

        int n = nums.length;

        // Step 1: Make a copy of nums
        Integer[] sorted = new Integer[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }

        // Step 2: Sort according to digit sum
        // If digit sums are equal, sort by number
        Arrays.sort(sorted, (a, b) -> {

            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if (sumA != sumB) {
                return sumA - sumB;
            }

            return a - b;
        });

        // Step 3: Store where each number should go
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(sorted[i], i);
        }

        // Step 4: Find cycles
        boolean[] visited = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i]) {
                continue;
            }

            int current = i;
            int cycleSize = 0;

            while (!visited[current]) {

                visited[current] = true;

                // Move to the position where this number
                // should be in the sorted array
                current = map.get(nums[current]);

                cycleSize++;
            }

            // A cycle of size k needs k-1 swaps
            ans += cycleSize - 1;
        }

        return ans;
    }

    // Function to calculate digit sum
    public int digitSum(int n) {

        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}