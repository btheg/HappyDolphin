import java.io.Serializable;

public class Kontingent implements Serializable
{
    public boolean betaltStatus;
    public boolean aktivStatus;
    public int beløb;

    public Kontingent(int alder)
    {
        this.betaltStatus = true;
        this.aktivStatus = true;

        //Sætter automatisk beløb ud fra alder
        if(alder<18)
        {
            this.beløb = 1000;
        } else if (alder>=18 && alder<60)
        {
            this.beløb = 1600;
        } else
        {
            this.beløb = 1200;
        }
    }


}
