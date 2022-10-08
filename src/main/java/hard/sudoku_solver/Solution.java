package hard.sudoku_solver;

class Solution {
    public void solveSudoku(char[][] board) {
        recursive(board);
        System.out.println("done");
    }

    private boolean recursive(char[][] board){
        int i, j=-1; boolean firstEmptyFound = false;
        for (i = 0; ! firstEmptyFound && i < 9;) {
            for (j = 0; !firstEmptyFound && j < 9; ) {
                if (board[i][j] == '.')
                    firstEmptyFound = true;
                else j++;
            }
            if (!firstEmptyFound) i++;
        }
        if (i== 9 || j == 9 )
            return true;

        for (int k = 1; k <= 9; k++) {
            char susp = (char) (k + '0');
            if (isValidState(susp,i,j,board)){
                board[i][j] = susp;
                if (recursive(board))
                    return true;
                board[i][j] = '.';
            }
        }
        return false;
    }
    private boolean isValidState(char value, int row, int col, char[][] board){
        for (int i = 0; i < 9; i++)
            if (board[i][col] == value)
                return false;
        for (int i = 0; i < 9; i++)
            if (board[row][i] == value)
                return false;
        int box_row = row / 3, box_col = col / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[box_row * 3 +i][box_col * 3+j] == value)
                    return false;
            }
        }
        return true;
    }
}
