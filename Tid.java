import java.io.Serializable;

public class Tid implements Serializable, Comparable<Tid>
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

    @Override
    public String toString()
    {
        return "\n" + this.svømmer.navn + ": " + this.tid + " sekunder";
    }

    public int compareTo(Tid tid)
    {
        if(this.tid == tid.tid)
        {
            return 0;
        } else if (this.tid > tid.tid)
        {
            return 1;
        }
        return -1;
    }
}
