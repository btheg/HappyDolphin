import java.io.Serializable;

public class Tid implements Serializable
{

    private Svømmer svømmer;
    private double tid;
    private Disciplin disciplin;

    public Tid(Svømmer svømmer, double tid, Disciplin disciplin) {
        this.svømmer = svømmer;
        this.tid = tid;
        this.disciplin = disciplin;
    }

    public Svømmer getSvømmer() {
        return svømmer;
    }

    public double getTid() {
        return tid;
    }

    public Disciplin getDisciplin() {
        return disciplin;
    }
}
