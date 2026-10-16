class Solution {
    static final long MOD = 1_000_000_007L;

    long[] sum;
    long[] square;
    long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        sum = new long[4 * n];
        square = new long[4 * n];
        lazy = new long[4 * n];
        int[] last = new int[100001];

        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }

        long ans = 0;

        for (int right = 0; right < n; right++) {

            int prev = last[nums[right]];
            update(1,0,n - 1,prev + 1,right,1);

            ans = (ans + square[1]) % MOD;

            last[nums[right]] = right;
        }

        return (int) ans;
    }

    void update(int node, int start, int end,
                int l, int r, long val) {

        if (r < start || end < l) {
            return;
        }

        if (l <= start && end <= r) {

            apply(node, start, end, val);

            return;
        }

        push(node, start, end);

        int mid = (start + end) / 2;

        update(node * 2,start,mid,l,r,val);

        update(
            node * 2 + 1,
            mid + 1,
            end,
            l,
            r,
            val
        );

        sum[node] =
            (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        square[node] =
            (square[node * 2] + square[node * 2 + 1]) % MOD;
    }

    void apply(int node, int start, int end, long val) {

        long len = end - start + 1;
        square[node] =
            (square[node]
            + 2 * val % MOD * sum[node] % MOD
            + val * val % MOD * len % MOD)
            % MOD;

        sum[node] =
            (sum[node] + val * len) % MOD;

        lazy[node] =
            (lazy[node] + val) % MOD;
    }

    void push(int node, int start, int end) {

        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = (start + end) / 2;

        apply(
            node * 2,
            start,
            mid,
            lazy[node]
        );

        apply(
            node * 2 + 1,
            mid + 1,
            end,
            lazy[node]
        );

        lazy[node] = 0;
    }
}