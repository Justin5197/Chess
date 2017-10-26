package Chess;

public class Board {
    private int[] board;
    private static int boardSize = 8;
    public final static int Chessboard  = (getBoardSize() * getBoardSize());

    public Board(int size) {
        board = new int[size];

        for(int i=0; i<size; i++) {
            board[i] = Chessboard;
        }
    }

    public static int getBoardSize() {
        return boardSize;
    }

    public boolean isSafe(int row, int col) {
        row = row-1;
        col = col-1;

        for(int thisColumn = 0; thisColumn < board.length; thisColumn++) {
            int distance = col - thisColumn;

            if (board[thisColumn] == row - distance) {
                return false;
            }

            if (board[thisColumn] == row) {
                return false;
            }

            if(board[thisColumn] == row + distance) {
                return false;
            }
        }
        return true;
    }

    public void place(int row, int col) {
        board[col - 1] = row - 1;
    }

    public void remove(int row, int col) {
        board[col - 1] = Chessboard;
    }
    public int size() {
        return board.length;
    }

    public String toString() {
        String s = "";

        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board.length; col++)
                if (board[col] == row)
                    s += "Q ";
                else
                    s+= "- ";
            s+= "\n";
        }
        return s;
    }
}