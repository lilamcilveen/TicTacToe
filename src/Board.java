import java.util.Scanner;


public class Board {

    private char marker_X = 'X';
    private char marker_O = 'O';
    private char currentMarker = 'X'; //game starts off with X
    private char BLANK = '_';

    private int boardSize;  //default board size is 3

    private char[][] board;

    private int playerTurn = 0; //keeps track of who's turn it is - alternates between 0 and 1
    private int plays = 1;  //keeps track of what turn the game is on

    /**********************
     ******GET METHODS*****
     **********************/
    public char getMarker_X()
    {
        return marker_X;
    }

    public char getMarker_O()
    {
        return marker_O;
    }

    public char getCurrentMarker()
    {
        return currentMarker;
    }

    public int getBoardSize()
    {
        return boardSize;
    }

    public int getPlayerTurn()
    {
        return playerTurn;
    }

    public int getPlays()
    {
        return plays;
    }

    /**********************
     ******SET METHODS*****
     **********************/

    public void setCurrentMarker(char currentMarker)
    {
        this.currentMarker = currentMarker;
    }

    public void setPlayerTurn(int playerTurn)
    {
        this.playerTurn = playerTurn;
    }

    public void setPlays(int plays)
    {
        this.plays = plays;
    }

    /**********************
     ***BOARD CONSTRUCTOR***
     **********************/
    public Board()
    {
        this(3);    //sets the boardSize to a default of 3
    }

    public Board(int boardSize)
    {
        this.boardSize = boardSize;
        board = new char[boardSize][boardSize];     //initializes board "array"
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = BLANK;    //sets default blank char to all spaces
            }

        }
    }

    /**********************
     ****DISPLAY BOARD*****
     **********************/
    public String display()
    {
        String currentLine = "";
        int counter = 0;    //keeps track of what array element is being checked
        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                counter++;
                currentLine += "[ "+ board[i][j] + " ]";

                //starts new line when necessary, to create "grid"
                if(counter%boardSize == 0)
                {
                    currentLine += "\n";
                }
            }
            System.out.println();
        }
        return currentLine;
    }

    /**********************
     *****SWITCH PLAYER*****
     **********************/
    public void switchPlayer()
    {
        if (getPlayerTurn() == 0)
        {
            setPlayerTurn(1);
            setCurrentMarker(getMarker_O());
        }
        else if (getPlayerTurn() == 1)
        {
            setPlayerTurn(0);
            setCurrentMarker(getMarker_X());
        }
        setPlays(getPlays() + 1);
    }

    /**********************
     *******ENTER MOVE******
     **********************/
    public void enterMove(String playerName)
    {
        System.out.println("TURN " + getPlays());
        System.out.print("Enter a move " + playerName + ": ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.replaceAll("\\s", "");    //removes whitespace ~ so it can be arbitrary when input
        int row = Integer.parseInt( input.split(",")[0] );
        int col = Integer.parseInt( input.split(",")[1] );

        if(validPlay(row, col))
        {
            board[row][col] = getCurrentMarker();
            System.out.println("Valid play.");
            switchPlayer();
        }
        else
        {
            System.out.println("Invalid play, try again");
            System.out.println();
            enterMove(playerName);
        }

    }

    /**********************
     **CHECK FOR VALID PLAY*
     **********************/
    public boolean validPlay(int row, int col)
    {
        if( row < 0 || col < 0 || col >= boardSize || row >= boardSize)
        {
            return false;
        }
        else if( board[row][col] != BLANK )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**********************
     ****CHECK FOR A WIN****
     **********************/
    public boolean win()
    {

        char spotChecked = '_';  //arbitrary space to compare with the rest of the row/col/diagonal pattern

        //checks each row
        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                if (!Character.isLetter(board[i][j]))   //if there's no char in space being checked, end 'j' loop - no win
                {
                    break;
                }

                if (j == 0)
                {
                    spotChecked = board[i][j];  //check the next value in the row
                }
                else if (spotChecked != board[i][j])    //if the next value isn't the same, no win
                {
                    break;
                }

                if (j == boardSize - 1)     //if j makes it to (boardSize-1), it had consecutive markings that were all the same - win
                {
                    return true;
                }
            }
        }

        //checks each column
        spotChecked = '_';
        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                if (!Character.isLetter(board[j][i]))
                {
                    break;
                }

                if (j == 0) {
                    spotChecked = board[j][i];
                }
                else if (spotChecked!= board[j][i])
                {
                    break;
                }

                if (j == boardSize - 1)
                {
                    return true;
                }
            }
        }

        //checks diagonals
        spotChecked = board[0][0];  //arbitrary value to start checking with
        if (boardSize == 3)
        {
            if (Character.isLetter(spotChecked) && board[1][1] == spotChecked && board[2][2] == spotChecked)
            {
                return true;
            }

            spotChecked = board[2][0];
            if (Character.isLetter(spotChecked) && board[1][1] == spotChecked && board[0][2] == spotChecked)
            {
                return true;
            }

        }

        else if (boardSize == 5)
        {
            spotChecked = board[0][0];
            if (Character.isLetter(spotChecked) && board[1][1] == spotChecked && board[2][2] == spotChecked && board[3][3] == spotChecked && board[4][4] == spotChecked)
            {
                return true;
            }

            spotChecked = board[4][0];
            if (Character.isLetter(spotChecked) && board[3][1] == spotChecked && board[2][2] == spotChecked && board[1][3] == spotChecked && board[0][4] == spotChecked)
            {
                return true;
            }
        }

        return false;
    }
}

