package TicTacToe;

public class Board {
    char[][] board;

    public Board() {
        board = new char[3][3];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';
    }

    public void displayBoard() {
        System.out.println("-----------------------------");
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    public boolean placeMark(int row, int col, char symbol) {
        if(row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-'){
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkWin(char symbol) {

        return checkRow(symbol) || checkCol(symbol) || checkDiagonal(symbol);
    }

    private boolean checkRow(char symbol) {
        for (int i = 0; i < 3; i++) {
            if(board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol){
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(char symbol) {
        for (int i = 0; i < 3; i++) {
            if(board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(char symbol) {

        return  (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    public boolean isBoardFull() {

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }
}
