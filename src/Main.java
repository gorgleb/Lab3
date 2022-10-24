import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TextFile file = new TextFile("src/text.txt");
        file.PrintFile();
        file.CopyFile();
        BinaryFile binFile = new BinaryFile("C:/Users/glekli/IdeaProjects/Lab3/src/in.bin");

        binFile.AddPlayer(new Player("Klimenko","Forward", 123, 123, LocalDate.now(),12));
        binFile.AddPlayer(new Player("Klimenko","Forward", 123, 123, LocalDate.now(),14));
        binFile.AddPlayer(new Player("Klimenko","Forward", 123, 123, LocalDate.now(),16));
        binFile.AddPlayer(new Player("Klimenko","Forward", 123, 123, LocalDate.now(),18));
        binFile.AddPlayer(new Player("Olegov","Forward", 123, 123, LocalDate.now(),12));
        binFile.AddPlayer(new Player("Olegov","Forward", 123, 123, LocalDate.now(),12));
        binFile.AddPlayer(new Player("Olegov","Forward", 123, 123, LocalDate.now(),12));
        binFile.writeFile();
        binFile.ClearArray();
        binFile.readFile();
        var bestForward = binFile.GetBestForward();

        try
        {
            FileOutputStream fos = new FileOutputStream("C:/Users/glekli/IdeaProjects/Lab3/src/out.txt");
            fos.write(String.format(
                    "Best forward surname:" +  bestForward.Surname
            ).getBytes());
            fos.close();
        }

         catch (FileNotFoundException exception){

        }
        catch (IOException exception){

        }
    }
}