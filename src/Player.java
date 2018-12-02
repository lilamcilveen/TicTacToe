import java.util.Scanner;
public class Player
{
    private String playerName;  //creates name variable
    private Boolean human;  //leaves opportunity to create AI


    /**********************
     ****GET/SET METHODS***
     **********************/
    public String getPlayerName()
    {
        return playerName;
    }



    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    /**********************
     ***PLAYER CONSTRUCTOR***
     **********************/

    Player()
    {
        this("default", true);
    }

    Player(String name, Boolean human)
    {
        this.playerName = name;
        this.human = human;
    }


}
