
import java.io.Serializable;
import java.time.LocalDate;

public class Player implements Serializable {
    public Player( String Surname, String Role, int Age, int GameCount, LocalDate LastGameDate,int ScoreCount)
    {
        this.Surname = Surname;
        this.Role = Role;
        this.Age = Age;
        this.GameCount = GameCount;
        this.LastGameDate = LastGameDate;
        this.ScoreCount = ScoreCount;
    }
    public  Player()
    {

    }
    public String Surname;
    public String Role;
    public int Age;
    public int GameCount;
    public LocalDate LastGameDate;
    public int ScoreCount;
}

