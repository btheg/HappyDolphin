import java.util.ArrayList;

public class RangListeListe {

    private ArrayList<RangListe> tider = new ArrayList<>();

    public RangListeListe() {}

    public void tilføjTid(Tid tid){

        for (RangListe r: tider)
        {
            if (tid.getDisciplin().equals(r.getDisciplin()))
            {
                r.getTider().add(tid);
            }
        }
    }
}
