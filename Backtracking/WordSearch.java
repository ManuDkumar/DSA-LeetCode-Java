class WordSearch {
     public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                 
                if (backtrack(board, word, w, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, char[] w, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length  || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != w[index]) {
         
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found = (backtrack(board, word, w, row + 1, col, index + 1) ||
                        backtrack(board, word, w, row - 1, col, index + 1) || 
                        backtrack(board, word, w, row, col + 1, index + 1) || 
                        backtrack(board, word, w, row, col - 1, index + 1));
        board[row][col] = temp;
        return found;
    }
}
