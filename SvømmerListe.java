import java.util.ArrayList;

public class SvømmerListe
{
    public ArrayList<Svømmer> svømmere = new ArrayList<>();

    public SvømmerListe() {}

    public void tilføjSvømmer(Svømmer svømmmer, Hold hold)
    {
        svømmere.add(svømmmer);
        System.out.println(svømmmer.navn + " tilføjet til medlemsliste!");
        hold.svømmere.add(svømmmer);
        System.out.println(svømmmer.navn + " tilføjet til " + hold.navn + "!");
    }


}
