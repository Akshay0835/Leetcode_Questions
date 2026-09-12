class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        Collections.sort(list);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {

            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), i);
            }
        }

        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = map.get(nums[i]);
        }

        return arr;
    }
}