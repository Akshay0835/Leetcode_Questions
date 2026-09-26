class Solution {
   static String solve(String s, int n, Map<String,String> map, String result) {
    String other = "";

    for(int i = 0; i < n; i++) {
        char ch = s.charAt(i);

        if(ch == '(') {
            result += other;
            other = "";

            String key = "";
            int count = 0;

            for(int j = i + 1; j < n; j++) {
                char ch2 = s.charAt(j);

                if(ch2 != ')') {
                    key += ch2;
                    count++;
                }
                else {
                    count++;
                    break;
                }
            }

            i += count;

            if(map.containsKey(key)) {
                result += map.get(key);
            }
            else {
                result += "?";
            }
        }
        else {
            other += ch;
        }
    }

    result += other;

    return result;
}
 public String evaluate(String s, List<List<String>> knowledge) {

    if(s.isEmpty()) {
        return s;
    }

    Map<String,String> map = new HashMap<>();

    for(int i = 0; i < knowledge.size(); i++) {
        map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
    }

    return solve(s, s.length(), map, "");
}
}