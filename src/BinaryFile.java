import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFile {

    private String path;
    private ArrayList<Player> playerList;
    public BinaryFile( String path)
    {
        this.path = path;
        playerList = new ArrayList<>();
    }
    public void AddPlayer(Player player)
    {
        this.playerList.add(player);
    }
    public void ClearArray()
    {
        playerList.clear();
    }
    public void writeFile() {
        try {
            FileOutputStream fos = new FileOutputStream(this.path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            var b = playerList.get()
            oos.writeObject(this.playerList);
            oos.close();
        }
        catch (IOException exception) {
            System.out.println("Wrong bin file path");
        }
    }
    public void readFile() {
        try {
            FileInputStream fis = new FileInputStream(this.path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.playerList = (ArrayList<Player>) ois.readObject();
            ois.close();
        }
        catch (IOException exception) {
            System.out.println("Wrong bin file path");
        }
        catch (ClassNotFoundException exception){
            System.out.println("Wrong class in the file");
        }
    }
    public Player GetBestForward()
    {
        int maxGoals= 0;
        int playerGoals = 0;
        Player BestForward = new Player();
        var forwards = GetForwards(this.playerList);
        for (Player player :
             forwards) {
            var gamesList =GetCurrentPlayerGames(forwards, player);
            for(Player forward : gamesList)
            {
                playerGoals += forward.ScoreCount;
            }
            if (playerGoals>maxGoals)
            {
                maxGoals = playerGoals;
                BestForward = player;
            }
            playerGoals = 0;

        }
        return  BestForward;

    }
    public ArrayList<Player> GetForwards(ArrayList<Player> players)
    {
        ArrayList<Player> forwards = new ArrayList<Player>();
        for(Player player : players)
        {
            if (player.Role.equals("Forward"))
            {
                forwards.add(player);
            }

        }
        return  forwards;
    }
    public ArrayList<Player> GetCurrentPlayerGames(ArrayList<Player> forwardsList, Player player)
    {
        ArrayList<Player> currentPlayerGames = new ArrayList<>();
        for (Player currentPlayer:
             forwardsList)
        {
            if (currentPlayer.Surname == player.Surname && currentPlayerGames.size()<=5)
            {
                currentPlayerGames.add(currentPlayer);
            }
        }
        return  currentPlayerGames;
    }
}
