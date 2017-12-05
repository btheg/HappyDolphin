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
                System.out.println("\nBekræftelsesmail er nu sendt til: " + svømmmer.email);

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

    public void setSvømmere(ArrayList<Svømmer> svømmere)
    {
        this.svømmere = svømmere;
    }

    public ArrayList<Svømmer> getBetalt(boolean betalt)
    {
        ArrayList<Svømmer> returnSvømmer = new ArrayList<>();
        for (Svømmer s: this.svømmere)
        {
            if(s.getKontingent().isBetalt()==betalt)
                returnSvømmer.add(s);
        }
        return returnSvømmer;
    }


    public void setBetalt(Svømmer svømmer, boolean restance)
    {
        svømmer.getKontingent().setBetalt(restance);
    }

    public ArrayList<Svømmer> getKonkurrence()
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
}
