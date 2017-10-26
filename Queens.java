package Chess;

public class Queens {

    public static void main(String[] args) {
        Board board = new Board(Board.getBoardSize());
        solveQueens(board);

    }

    public static boolean explore (Board board, int col){

        if(col > board.size()){
            return true;

        } else {

            for(int row = 1; row <= board.size(); row++){

                if (board.isSafe(row, col)){
                    board.place(row, col);

                    if(explore(board, col+1)){
                        return true;
                    }

                    board.remove(row, col);
                }
            }

            return false;
        }
    }

    public static void solveQueens(Board board){

        if(!explore(board, 1)){
            System.out.println("No solution found.");

        } else {
            System.out.println(board);
        }
    }
}