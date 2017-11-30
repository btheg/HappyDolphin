import java.util.ArrayList;

public class SvømmerListe
{
    private ArrayList<Svømmer> svømmere = new ArrayList<>();

    public SvømmerListe() {}

    public void tilføjSvømmer(Svømmer svømmmer, Hold hold)
    {
        //Hvis aldersgruppe og konkurrence type passer:
        if(svømmmer.isKonkurrence()==hold.isKonkurrence())
        {
            if(svømmmer.getAlder()<18 && hold.isJunior()||
                    svømmmer.getAlder()>=18 && !hold.isJunior())
            {
                //Gør det her:
                svømmere.add(svømmmer);
                System.out.println(svømmmer.navn + " tilføjet til medlemsliste!");
                hold.getSvømmere().add(svømmmer);
                System.out.println(svømmmer.navn + " tilføjet til " + hold.getNavn() + "!");
                System.out.println(svømmmer.navn + " er nu oprettet i systemet");
                System.out.println();

            } else
            {
                System.out.println("Aldersgruppen for holdet, matcher ikke medlemmets alder");
            }
        } else
        {
            System.out.println("Konkurrence type for holdet matcher ikke medlemmet");
        }

    }

    public ArrayList<Svømmer> getSvømmere()
    {
        return svømmere;
    }

    public Svømmer getViaMail(String mail)
    {
        for (Svømmer s: svømmere)
        {
            if (s.email.equalsIgnoreCase(mail))
            {
                return s;
            }
        }
        return null;
    }


    public ArrayList<Svømmer> getViaKonkurrence()
    {
        ArrayList<Svømmer> konSvømmere = new ArrayList<>();
        for (Svømmer s: svømmere)
        {
            if (s.isKonkurrence())
            {
                konSvømmere.add(s);
            }
        }
        return  konSvømmere;
    }

    public void setSvømmere(ArrayList<Svømmer> svømmere)
    {
        this.svømmere = svømmere;
    }
}
