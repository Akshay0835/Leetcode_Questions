class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int max = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '[') {
                open++;
            }
            else {
                open--;
            }

            max = Math.max(max, -open);
        }

        return (max + 1) / 2;
    }
}