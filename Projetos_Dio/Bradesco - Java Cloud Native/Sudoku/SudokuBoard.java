public class SudokuBoard {
    private int[][] board = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    public int getValue(int row, int col) {
        return board[row][col];
    }

    public boolean isValidMove(int row, int col, int num) {
        if (board[row][col] != 0) return false;

        for (int i = 0; i < 9; i++)
            if (board[row][i] == num || board[i][col] == num)
                return false;

        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++)
            for (int j = boxCol; j < boxCol + 3; j++)
                if (board[i][j] == num)
                    return false;

        return true;
    }

    public void placeNumber(int row, int col, int num) {
        board[row][col] = num;
    }

    public boolean isBoardFull() {
        for (int[] row : board)
            for (int cell : row)
                if (cell == 0) return false;
        return true;
    }
}
