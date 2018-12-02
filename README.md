# TicTacToe
A 2 player tic tac toe game implemented in java.

Players can play on a 3x3 or 5x5 grid.
- Acceptable command line arguments are "3", "5", "three", "five".
- A lack of a valid command line argument terminates the program with a usage message.

Input [y-axis], [x-axis]

Example:

      Welcome to  TIC TAC TOE 

      The objective of this game is to place your markings in  
      a way to form a full horizontal, diagonal, or vertical row.

      To select a position on the board, input:   'ROW', 'COLUMN' 
      The first row is 0, the first column is 0.

      Player 1 (The 'X'): Enter name: Ms Cat

      Player 2 (The 'O'): Enter name: Egg Man

      [ _ ][ _ ][ _ ]
      [ _ ][ _ ][ _ ]
      [ _ ][ _ ][ _ ]

      --------------
      TURN 1
      Enter a move Ms Cat: 1, 1
      Valid play.

      [ _ ][ _ ][ _ ]
      [ _ ][ X ][ _ ]
      [ _ ][ _ ][ _ ]

      --------------
      TURN 2
      Enter a move Egg Man: 0,0
      Valid play.

      [ O ][ _ ][ _ ]
      [ _ ][ X ][ _ ]
      [ _ ][ _ ][ _ ]

      --------------
      TURN 3
      Enter a move Ms Cat: 1 ,2
      Valid play.
      [ O ][ _ ][ _ ]
      [ _ ][ X ][ X ]
      [ _ ][ _ ][ _ ]

      --------------
      TURN 4
      Enter a move Egg Man: 1, 32
      Invalid play, try again

      TURN 4
      Enter a move Egg Man: 2, 1
      Valid play.

      [ O ][ _ ][ _ ]
      [ _ ][ X ][ X ]
      [ _ ][ O ][ _ ]

      --------------
      TURN 5
      Enter a move Ms Cat: 1,0
      Valid play.

      [ O ][ _ ][ _ ]
      [ X ][ X ][ X ]
      [ _ ][ O ][ _ ]

      - Ms Cat has won! -
      GAME OVER
   

Created on October 20, 2017.
