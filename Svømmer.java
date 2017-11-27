import java.io.Serializable;
import java.util.ArrayList;

public class Svømmer extends Medlem implements Serializable
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

    @Override
    public String toString()
    {
        return this.navn + " " + this.alder + " år" + "  Mail: " + this.email;
    }


}
