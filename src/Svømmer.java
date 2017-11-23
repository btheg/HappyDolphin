import java.util.ArrayList;

public class Svømmer extends Medlem
{

    public Kontingent kontingent;
    public ArrayList<Disciplin> aktiveDiscipliner;
    public boolean konkurrence;

    public Svømmer(String navn, String email, int alder, boolean konkurrence)
    {
        super(navn, email, alder);
        this.kontingent = new Kontingent(alder);
        this.konkurrence = konkurrence;

        //Hvis konkurrence svømmer, lav arrayliste af discipliner
        if (konkurrence)
        {
            this.aktiveDiscipliner = new ArrayList<Disciplin>();
        }
    }


}