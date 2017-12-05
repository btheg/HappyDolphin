import java.util.ArrayList;

public class HoldListe
{
    private ArrayList<Hold> hold = new ArrayList<>();

    public HoldListe(){}

    public void init()
    {
        this.hold.add(new Hold("Junior Hold 1","Børge", false, true));
        this.hold.add(new Hold("Junior Hold 2","Carsten",false,true));
        this.hold.add(new Hold("Senior Hold 1","Børge",false,false));
        this.hold.add(new Hold("Senior Hold 2", "Børge",false, false));
        this.hold.add(new Hold("Junior Konkurrence Guld","Carsten",true,true));
        this.hold.add(new Hold("Junior Konkurrence Sølv","Børge",true,true));
        this.hold.add(new Hold("Senior Konkurrence Guld","Carsten",true,false));
        this.hold.add(new Hold("Senior Konkurrence Sølv","Børge",true,false));
    }

    public Hold get(String navn)
    {
        for (Hold h: hold)
            {
                if (h.getNavn().equalsIgnoreCase(navn))
                    return h;
            }
        return null;
    }

    public ArrayList<Hold> getHold()
    {
        return hold;
    }

    public void setHold(ArrayList<Hold> hold)
    {
        this.hold = hold;
    }

    public void sletSvømmer(Svømmer svømmer)
    {
        Svømmer sletsvømmer = new Svømmer();
        Hold slethold = new Hold();
        for (Hold h: this.hold)
        {
            for (Svømmer s: h.getSvømmere())
            {
                if(s.email.equals(svømmer.email))
                {
                    sletsvømmer = s;
                    slethold = h;
                }
            }
        }
        try
        {
            slethold.getSvømmere().remove(sletsvømmer);
            System.out.println(sletsvømmer.navn + " er nu fjernet fra " + slethold.getNavn());
        } catch (Exception e)
        {}
    }

    public void skiftHold(Svømmer svømmer, Hold hold)
    {
        this.sletSvømmer(svømmer);
        hold.getSvømmere().add(svømmer);
        System.out.println(svømmer.navn + " er nu på " + hold.getNavn());
    }

    public void redigerActive (boolean active, Svømmer svømmer)
    {
        for (Hold h: this.hold)
        {
            for (Svømmer s: h.getSvømmere())
            {
                if(s.email.equals(svømmer.email))
                {
                    s.redigerActive(active);
                }
            }
        }
    }
}
