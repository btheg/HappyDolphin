import java.util.ArrayList;

public class DisciplinListe
{
    public ArrayList<Disciplin> discipliner = new ArrayList<>();

    public DisciplinListe() {}

    public Disciplin get(String type)
    {
        for (Disciplin d: discipliner)
        {
            if (d.type.equalsIgnoreCase(type))
                return d;
        }
        return null;
    }


    public void init()
    {
        this.discipliner.add(new Disciplin("Crawl"));
        this.discipliner.add(new Disciplin("Butterfly"));
        this.discipliner.add(new Disciplin("Rygcrawl"));
        this.discipliner.add(new Disciplin("Brystsvømning"));
        this.discipliner.add(new Disciplin("Hundesvømning"));
    }

}
