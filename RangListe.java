import java.io.Serializable;
import java.util.ArrayList;


public class RangListe implements Serializable
{

    private ArrayList<Tid> tider = new ArrayList<>();
    private Disciplin disciplin;

    public RangListe (Disciplin disciplin) {
        this.disciplin = disciplin;
    }

    public Disciplin getDisciplin() {
        return disciplin;
    }

    public ArrayList<Tid> getTider() {
        return tider;
    }
}