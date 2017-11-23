import java.util.ArrayList;

public class Hold
{
    public String navn;
    public String træner;
    public ArrayList<Medlem> svømmere = new ArrayList<>();

    public Hold(String navn)
    {
        this.navn = navn;
    }

    public Hold(String navn, String træner)
    {
        this.navn = navn;
        this.træner = træner;
    }


}
