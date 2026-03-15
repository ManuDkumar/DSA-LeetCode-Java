class NQueens {
  public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(result, board, n, 0);
        return result;
    }

    public void backtrack(List<List<String>> result, char[][] board, int n, int row) {
        if (row == n) {
            result.add(constract(board));
            return;
        }

        for(int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(result, board, n, row + 1);
                board[row][col] = '.';
            }
        }

    }

    private boolean isValid(char[][] board, int row, int col, int n) {

        for(int i = 0 ; i < row; i++ ) {
            if (board[i][col] == 'Q') {
                return false;
            }
            if ((col - (row - i) >= 0) && (board[i][col - (row - i)] == 'Q')) {
                return false;
            }
            if ((col + (row - i) < n ) && (board[i][col + (row - i)] == 'Q')) {
                return false;
            }
        }
        return true;
    }

    private List<String> constract(char[][] board) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
