class Solution {

    public int maxVowels(String s, int k) {

        int count=0;

        for(int i=0;i<k;i++){

            char ch=s.charAt(i);

            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
        }
        int ans=count;
        for(int j=k;j<s.length();j++){

            char remove=s.charAt(j-k);
            char add=s.charAt(j);

            if(remove=='a'||remove=='e'||remove=='i'||remove=='o'||remove=='u'){
                ans--;
            }

            if(add=='a'||add=='e'||add=='i'||add=='o'||add=='u'){
                ans++;
            }

            count=Math.max(count,ans);
        }

        return count;
    }
}