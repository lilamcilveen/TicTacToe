import java.util.Scanner;
public class TicTacToeApp
{
    public static void main (String[] args)
    {

        Board game = new Board();

        String playerName;
        Player player1 = new Player();
        Player player2 = new Player();

        Scanner sc = new Scanner(System.in);


        int numericArg;     //creates an int for a plausible numeric argument

        /**********************
         ***COMMAND LINE ARGS***
         **********************/
        if( args.length == 0)   //if there is a lack of a command line argument
        {
            System.err.println("No argument passed. Please use 'three', 'five, '3', or '5' as your argument. Program will now terminate.");
            System.exit(1);     //terminate program
        }
        else if( args.length > 0 && args[0].equals("five"))
        {
            game = new Board(5);
        }
        else if( args.length > 0 && args[0].equals("three" ))
        {
            game = new Board(3);
        }

        else if (args.length > 0 )
        {
            try
            {
                numericArg = Integer.parseInt(args[0]);
                if(numericArg == 3)
                {
                    game = new Board(3);
                    //System.out.println(game.getBoardSize());
                }
                else if(numericArg == 5)
                {
                    game = new Board(5);
                    //System.out.println(game.getBoardSize());
                }
                else
                {
                    System.err.println("Argument entered, '" + args[0] + "', is an invalid input. Please use 'three', 'five, '3', or '5' as your argument. Program will now terminate.");
                    System.exit(1);
                }
            } catch (NumberFormatException e)
            {
                System.err.println("Argument entered, '" + args[0] + "', is an invalid input. Please use 'three', 'five, '3', or '5' as your argument. Program will now terminate.");
                System.exit(1);
            }
        }


        /**********************
         ****SETUP TO GAME***
         **********************/
        System.out.println("Welcome to  TIC TAC TOE ");
        System.out.println();
        System.out.println("   The objective of this game is to place your markings in  ");
        System.out.println("   a way to form a full horizontal, diagonal, or vertical row.");
        System.out.println();
        System.out.println("   To select a position on the board, input:   'ROW', 'COLUMN' ");
        System.out.println("   The first row is 0, the first column is 0.");
        System.out.println();

        System.out.print("Player 1 (The 'X'): Enter name: ");
        playerName = sc.nextLine();
        player1.setPlayerName(playerName);
        System.out.println();
        System.out.print("Player 2 (The 'O'): Enter name: ");
        playerName = sc.nextLine();
        player2.setPlayerName(playerName);

        System.out.println(game.display());


        /**********************
         *****THE GAME LOOP****
         **********************/
        //game loop ends when either a player wins, or the plays made exceed the number of spaces on the board
        while (!game.win() && game.getPlays() < (game.getBoardSize() * game.getBoardSize()) + 1)
        {
            if (game.getPlayerTurn() == 0)
            {
                System.out.println("--------------");
                game.enterMove(player1.getPlayerName());
                System.out.println(game.display());
                if (game.win())
                {
                    System.out.println("- " + player1.getPlayerName() + " has won! -");
                    System.out.println("GAME OVER");
                    break;
                }
            }
            else if (game.getPlayerTurn() == 1)
            {
                System.out.println("--------------");
                game.enterMove(player2.getPlayerName());
                System.out.println(game.display());
                if (game.win())
                {
                    System.out.println("- " + player2.getPlayerName() + " has won! -");
                    System.out.println("GAME OVER");
                    break;
                }
            }
        }

        //lets the user know if the game was a draw
        if (game.getPlays() > (game.getBoardSize() * game.getBoardSize()))
        {
            System.out.println("- Draw -");
            System.out.println("GAME OVER");

        }
    }
}
