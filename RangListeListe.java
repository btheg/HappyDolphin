import java.util.ArrayList;

public class RangListeListe {

    private ArrayList<RangListe> rangLister = new ArrayList<>();

    public RangListeListe() {}

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

    public void tilføjTid(Tid tid){
        for (RangListe r: rangLister)
        {
            if (tid.getDisciplin().getType().equalsIgnoreCase(r.getDisciplin().getType()))
            {
                r.getTider().add(tid);
            }
        }
    }

    public ArrayList<RangListe> getRangLister()
    {
        return this.rangLister;
    }

    public void setRangLister(ArrayList<RangListe> rangLister)
    {
        this.rangLister = rangLister;
    }
}