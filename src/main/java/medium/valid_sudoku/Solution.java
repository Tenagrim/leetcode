package medium.valid_sudoku;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !isValidState(board[i][j],i,j,board))
                    return false;
            }
        }
        return true;
    }

    private boolean isValidState(char value, int row, int col, char[][] board){
        for (int i = 0; i < 9; i++)
            if (i != row && board[i][col] == value)
                return false;
        for (int i = 0; i < 9; i++)
            if (i != col && board[row][i] == value)
                return false;
        int box_row = row / 3, box_col = col / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int pos_r = box_row * 3 +i, pos_c = box_col * 3+j;
                if (board[pos_r][pos_c] == value && pos_c != col && pos_r != row)
                    return false;
            }
        }
        return true;
    }
}
