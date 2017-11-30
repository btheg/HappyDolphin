import java.io.Serializable;

public class Medlem implements Serializable
{
    protected String navn;
    protected String email;
    protected int alder;

    public Medlem(){}

    public int getAlder()
    {
        return alder;
    }

    public Medlem(String navn, String email, int alder)
    {
        this.navn = navn;
        this.email = email;
        this.alder = alder;
    }
}
