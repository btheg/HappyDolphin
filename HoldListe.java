import java.util.ArrayList;

public class HoldListe
{
    public ArrayList<Hold> hold = new ArrayList<>();

    public HoldListe(){}

    public void init()
    {
        this.hold.add(new Hold("Hold 1","Børge"));
        this.hold.add(new Hold("Hold 2","Carsten"));
        this.hold.add(new Hold("Hold 3","Børge"));
        this.hold.add(new Hold("Hold 4", "Børge"));
        this.hold.add(new Hold("Konkurrence Junior","Carsten"));
        this.hold.add(new Hold("Konkurrence Senior","Carsten"));
    }

}
