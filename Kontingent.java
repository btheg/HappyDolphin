import java.io.Serializable;

public class Kontingent implements Serializable
{
    private boolean betalt;
    private boolean aktiv;
    private int beløb;

    public Kontingent(int alder)
    {
        this.betalt = true;
        this.aktiv = true;

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

    public void redigerActive(int alder, boolean aktiv)
    {
        if(aktiv)
        {
            this.aktiv = true;
            if (alder < 18)
            {
                this.beløb = 1000;
            } else if (alder >= 18 && alder < 60)
            {
                this.beløb = 1600;
            } else
            {
                this.beløb = 1200;
            }
        } else
        {
            this.aktiv = false;
            this.beløb = 500;
        }
    }

    public void setBetalt(boolean betalt)
    {
        this.betalt = betalt;
    }

    public boolean isBetalt()
    {
        return betalt;
    }

    public boolean isAktiv()
    {
        return aktiv;
    }
}
