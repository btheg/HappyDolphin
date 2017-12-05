import java.io.Serializable;
import java.util.ArrayList;

public class Svømmer extends Medlem implements Serializable
{

    private Kontingent kontingent;
    private boolean konkurrence;

    public Svømmer(String navn, String email, int alder, boolean konkurrence)
    {
        super(navn, email, alder);
        this.kontingent = new Kontingent(alder);
        this.konkurrence = konkurrence;
    }

    public void redigerActive(boolean active)
    {
        this.kontingent.redigerActive(this.alder,active);
    }

    public Svømmer()
    {}

    public boolean isKonkurrence()
    {
        return konkurrence;
    }

    public void setKonkurrence(boolean konkurrence)
    {
        this.konkurrence = konkurrence;
    }

    public Kontingent getKontingent()
    {
        return kontingent;
    }

    @Override
    public String toString()
    {
        if(this.kontingent.isAktiv())
        {
            return "\n" + this.navn + " " + this.alder + " år" + "  Mail: " + this.email;
        } else
        {
            return "\n" + this.navn + " " + "Mail: " + this.email + " \t\t\tPASSIVT MEDLEM";
        }
    }
}
