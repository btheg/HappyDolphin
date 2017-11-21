import java.util.ArrayList;

public class Medlem
{
    public String name;
    public int alder;
    public String mail;
    public Kontingent kontingent;
    public ArrayList<Disciplin> aktiveDiscipliner;

    public Medlem(String name, int alder, String mail, boolean konkurrence)
    {
        this.name = name;
        this.alder = alder;
        this.mail = mail;
        this.kontingent = new Kontingent(this.alder);

        //Hvis konkurrence svømmer, lav arrayliste af discipliner
        if (konkurrence)
        {
            this.aktiveDiscipliner = new ArrayList<Disciplin>();
        }
    }


}
