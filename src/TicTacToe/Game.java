package TicTacToe;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }


    public void play() {

        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;

        System.out.println("Welcome to Tic-Tac-Toe Game!");
        board.displayBoard();

        while( !board.isBoardFull() && !gameOver ) {

            System.out.println(currentPlayer.getName() + "'s turn " + currentPlayer.getSymbol());

            System.out.println("Enter the row value(0 - 2)");
            int row = sc.nextInt();
            System.out.println("Enter the column value(0 - 2)");
            int col = sc.nextInt();

            if(board.placeMark(row, col, currentPlayer.getSymbol())) {
                board.displayBoard();

                if(board.checkWin(currentPlayer.getSymbol())) {
                    System.out.println("Congratulations! " + currentPlayer.getName() + " You won!");
                    gameOver = true;
                }
                else {
                    switchPlayer();
                }
            }
            else {
                System.out.println("Invalid Move! Try Again");
            }
        }

        if(!gameOver) {
            System.out.println("Its a Draw!");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
