class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {

        List<Double> list = new ArrayList<>();
        List<Double> window = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            window.add((double) nums[i]);
        }

        Collections.sort(window);

        double median = 0;

        if (k % 2 == 0) {
            median = (window.get(k / 2) + window.get((k / 2) - 1)) / 2.0;
        } else {
            median = window.get(k / 2);
        }

        list.add(median);


        for (int i = k; i < nums.length; i++) {

            double remove = (double) nums[i - k];

            int index = Collections.binarySearch(window, remove);
            window.remove(index);

            double add = (double) nums[i];

            int pos = Collections.binarySearch(window, add);

            if (pos < 0) {
                pos = -pos - 1;
            }

            window.add(pos, add);

            if (k % 2 == 0) {
                median = (window.get(k / 2)
                        + window.get((k / 2) - 1)) / 2.0;
            } else {
                median = window.get(k / 2);
            }

            list.add(median);
        }

        double[] ans = new double[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}