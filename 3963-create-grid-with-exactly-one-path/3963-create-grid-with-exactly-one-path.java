class Solution {
    public String[] createGrid(int m, int n) {
       String grid[][]=new String[m][n];
       for(int i=0;i<m;i++){
        Arrays.fill(grid[i],"#");
       }
       for(int i=0;i<n;i++){
        grid[0][i]=".";
       }
       for(int i=0;i<m;i++){
        grid[i][n-1]=".";
       }
       String ans[]=new String[m];
       for(int i=0;i<m;i++){
        String curr="";
        for(int j=0;j<n;j++){
            curr+=grid[i][j];
        }
        ans[i]=curr;
       }
       return ans;
    }
}