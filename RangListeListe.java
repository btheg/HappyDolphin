import java.util.ArrayList;
import java.io.Serializable;

public class RangListeListe implements Serializable
{

    private ArrayList<RangListe> rangLister = new ArrayList<>();

    public RangListeListe()
    {
        this.init();
    }

    public RangListe getViaDisciplin(Disciplin disciplin)
    {
        for (RangListe r: this.rangLister)
        {
            if(r.getDisciplin().getType().equals(disciplin.getType()))
            {
                return r;
            }
        }
        return null;
    }

    public void tilføjTid(Tid tid){

        for (RangListe r: rangLister)
        {
            if (tid.getDisciplin().getType().equalsIgnoreCase(r.getDisciplin().getType()))
            {
                r.getTider().add(tid);
                System.out.println("Tid er nu filføjet");
            }
        }
    }

    public void init()
    {
        DisciplinListe dl = new DisciplinListe();
        dl.init();
        this.rangLister.add(new RangListe(dl.get("crawl")));
        this.rangLister.add(new RangListe(dl.get("butterfly")));
        this.rangLister.add(new RangListe(dl.get("rygcrawl")));
        this.rangLister.add(new RangListe(dl.get("brystsvømning")));
        this.rangLister.add(new RangListe(dl.get("hundesvømning")));
    }

    public ArrayList<RangListe> getRangLister()
    {
        return rangLister;
    }

    public void setRangLister(ArrayList<RangListe> rangLister)
    {
        this.rangLister = rangLister;
    }
}
