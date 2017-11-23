import java.io.Serializable;

public class Medlem implements Serializable
{
    public String navn;
    public String email;
    public int alder;

    public Medlem(){}

    public Medlem(String navn, String email, int alder)
    {
        this.navn = navn;
        this.email = email;
        this.alder = alder;
    }
}
