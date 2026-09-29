class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word = null;
    }

    TrieNode root = new TrieNode();
    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (curr.child[index] == null) {
                    curr.child[index] = new TrieNode();
                }

                curr = curr.child[index];
            }

            curr.word = word;
        }

        int m = board.length;
        int n = board[0].length;

        // Start DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                solve(board, i, j, root);
            }
        }

        return ans;
    }

    void solve(char[][] board, int i, int j, TrieNode node) {

        // Boundary check
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length) {
            return;
        }

        char ch = board[i][j];

        // Already visited
        if (ch == '#') {
            return;
        }

        int index = ch - 'a';

        // No word has this prefix
        if (node.child[index] == null) {
            return;
        }

        TrieNode curr = node.child[index];

        // Found a complete word
        if (curr.word != null) {
            ans.add(curr.word);

            // Prevent duplicate answer
            curr.word = null;
        }

        // Mark visited
        board[i][j] = '#';

        // Up
        solve(board, i - 1, j, curr);

        // Down
        solve(board, i + 1, j, curr);

        // Left
        solve(board, i, j - 1, curr);

        // Right
        solve(board, i, j + 1, curr);

        // Backtrack
        board[i][j] = ch;
    }
}