class Solution {
    static int index = 0;

    static Set<String> solve(String s) {

        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();

        current.add("");

        while (index < s.length() && s.charAt(index) != '}') {

            if (s.charAt(index) == ',') {

                result.addAll(current);
                current.clear();
                current.add("");

                index++;
            }

            else {

                Set<String> part;

                if (s.charAt(index) == '{') {

                    index++;
                    part = solve(s);
                    index++;

                }

                else {

                    part = new HashSet<>();
                    part.add(String.valueOf(s.charAt(index)));

                    index++;
                }

                Set<String> temp = new HashSet<>();

                for (String a : current) {
                    for (String b : part) {
                        temp.add(a + b);
                    }
                }

                current = temp;
            }
        }

        result.addAll(current);

        return result;
    }

    public List<String> braceExpansionII(String expression) {

        index = 0; 

        Set<String> result = solve(expression);

        List<String> ans = new ArrayList<>(result);

        Collections.sort(ans);

        return ans;
    }
}