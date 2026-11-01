class Solution {
    public int minMoves(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i:nums){
            list.add(i);
        }
        int min=Collections.min(list);
        int moves=0;
        for(int i:nums){
            moves+=i-min;
        }
        return moves;
    }
}