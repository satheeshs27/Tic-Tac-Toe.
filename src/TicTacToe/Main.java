package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Player 1 Name: ");
        String name1 = sc.nextLine();
        System.out.println("Enter Player 2 Name: ");
        String name2 = sc.nextLine();

        Player player1 = new Player(name1, 'X');
        Player player2 = new Player(name2, 'O');

        Game game = new Game(player1, player2);

        game.play();



    }
}
