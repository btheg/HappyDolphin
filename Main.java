public class Main
{
    public static void main(String[] args)
    {
        /*
        Svømmer martin = new Svømmer("Martin Borup-Larsen","wuddup@gmail.com",21,true);
        Svømmer mikkel = new Svømmer("Mikkel Olsen","damnson@gmail.com",24,true);
        Svømmer kasper = new Svømmer("Kasper Lovin","maddafakka@yahoo.dk",17,false);
        Svømmer matias = new Svømmer("Matias Gramkow","flødetino@gmail.com",62,false);

        SvømmerListe wuddup = new SvømmerListe();

        HoldListe holdListe = new HoldListe();
        holdListe.init();
        wuddup.tilføjSvømmer(martin, holdListe.hold.get(0));
        wuddup.tilføjSvømmer(mikkel, holdListe.hold.get(1));
        wuddup.tilføjSvømmer(kasper, holdListe.hold.get(0));
        wuddup.tilføjSvømmer(matias, holdListe.hold.get(5));
        */
        FileHandler fh = new FileHandler();
        //fh.writeSvømmerList(wuddup.svømmere,"hej.txt");
        //System.out.println("Helt sikkert!");

        System.out.println(fh.readSvømmerListe("hej.txt"));
        //System.out.println(wuddup.svømmere);


    }
}
