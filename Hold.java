import java.io.Serializable;
import java.util.ArrayList;

public class Hold implements Serializable
{
    private String navn;
    private String træner;
    private boolean konkurrence;
    private boolean junior;
    private ArrayList<Svømmer> svømmere = new ArrayList<>();

    public Hold()
    {}

    public Hold(String navn, String træner, boolean konkurrence, boolean junior)
    {
        this.navn = navn;
        this.træner = træner;
        this.konkurrence = konkurrence;
        this.junior = junior;

    }

    public ArrayList<Svømmer> getSvømmere()
    {
        return svømmere;
    }

    public String getNavn()
    {
        return navn;
    }

    public boolean isKonkurrence()
    {
        return konkurrence;
    }

    public boolean isJunior()
    {
        return junior;
    }

    @Override
    public String toString()
    {
        return "\n\n" + this.navn + ":\n" + this.svømmere;
    }


}
