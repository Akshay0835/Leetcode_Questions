class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        for(int i : nums2) {
            list.add(i);
        }

        int ans[] = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {

            int index = list.indexOf(nums1[i]);

            ans[i] = -1;

            for(int j = index + 1; j < list.size(); j++) {
                if(list.get(j) > nums1[i]) {
                    ans[i] = list.get(j);
                    break;
                }
            }
        }

        return ans;
    }
}