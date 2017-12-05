// Authors: Martin og Mikkel
import java.io.*;
import java.util.ArrayList;

public class FileHandler
{
    private File file;
    private FileOutputStream fileOutputStream;
    private BufferedOutputStream bufferedOutputStream;
    private ObjectOutputStream objectOutputStream;

    private FileInputStream fileInputStream;
    private BufferedInputStream bufferedInputStream;
    private ObjectInputStream objectInputStream;

    public void writeSvømmerList(ArrayList<Svømmer> svømmere, String path)
    {
        try
        {
            //Vi opretter en fil, og gemmer en liste af svømmere deri
            this.file = new File(path);
            this.fileOutputStream = new FileOutputStream(this.file);
            this.bufferedOutputStream = new BufferedOutputStream(this.fileOutputStream);
            this.objectOutputStream = new ObjectOutputStream(this.bufferedOutputStream);

            this.objectOutputStream.writeObject(svømmere);

            this.objectOutputStream.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Svømmer> readSvømmerListe(String path)
    {
        ArrayList<Svømmer> svømmerReturn = new ArrayList<>();

        try
        {
            this.file = new File(path);
            this.fileInputStream = new FileInputStream(this.file);
            this.bufferedInputStream = new BufferedInputStream(this.fileInputStream);
            this.objectInputStream = new ObjectInputStream(this.bufferedInputStream);

            svømmerReturn = (ArrayList<Svømmer>)this.objectInputStream.readObject();

            this.objectInputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return svømmerReturn;
    }


    public void writeHoldList(ArrayList<Hold> hold, String path)
    {
        try
        {
            //Vi opretter en fil, og gemmer en liste af svømmere deri
            this.file = new File(path);
            this.fileOutputStream = new FileOutputStream(this.file);
            this.bufferedOutputStream = new BufferedOutputStream(this.fileOutputStream);
            this.objectOutputStream = new ObjectOutputStream(this.bufferedOutputStream);

            this.objectOutputStream.writeObject(hold);

            this.objectOutputStream.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Hold> readHoldListe(String path)
    {
        ArrayList<Hold> holdReturn = new ArrayList<>();

        try
        {
            this.file = new File(path);
            this.fileInputStream = new FileInputStream(this.file);
            this.bufferedInputStream = new BufferedInputStream(this.fileInputStream);
            this.objectInputStream = new ObjectInputStream(this.bufferedInputStream);

            holdReturn = (ArrayList<Hold>)this.objectInputStream.readObject();

            this.objectInputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return holdReturn;
    }

    public void writeRangListeListe(ArrayList<RangListe> ranglist,String path)
    {
        try
        {
            //Vi opretter en fil, og gemmer en liste af ranglister deri
            this.file = new File(path);
            this.fileOutputStream = new FileOutputStream(this.file);
            this.bufferedOutputStream = new BufferedOutputStream(this.fileOutputStream);
            this.objectOutputStream = new ObjectOutputStream(this.bufferedOutputStream);

            this.objectOutputStream.writeObject(ranglist);

            this.objectOutputStream.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public ArrayList<RangListe> readRangListeListe (String path)
    {
        ArrayList<RangListe> rangListeListeReturn = new ArrayList<>();
        try
        {
            this.file = new File(path);
            this.fileInputStream = new FileInputStream(this.file);
            this.bufferedInputStream = new BufferedInputStream(this.fileInputStream);
            this.objectInputStream = new ObjectInputStream(this.bufferedInputStream);

            rangListeListeReturn = (ArrayList<RangListe>)this.objectInputStream.readObject();

            this.objectInputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rangListeListeReturn;
    }
}
