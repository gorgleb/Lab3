import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile
{
    private String _path;
    public  TextFile( String path)
    {
        _path = path;
    }
    public void PrintFile()
    {
        try(FileReader reader = new FileReader(this._path))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public void CopyFile()
    {
        try(FileReader reader = new FileReader(this._path))
        {
            try(FileWriter writer = new FileWriter("copiedFile", false))
            {

                int c;
                while((c=reader.read())!=-1){

                    writer.append((char)c);
                }
                writer.flush();
            }


        }

        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

