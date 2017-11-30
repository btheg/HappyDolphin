import java.util.ArrayList;

public class RangListe
{
    private ArrayList<Tid> tider = new ArrayList<>();
    private Disciplin disciplin;

    public RangListe () {

    }

    public Disciplin getDisciplin() {
        return disciplin;
    }

    public ArrayList<Tid> getTider() {
        return tider;
    }
}
