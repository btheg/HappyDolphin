public class Main
{
    public static void main(String[] args)
    {
        Medlem martin = new Medlem("Martin Borup-Larsen",21,"fedeko@gmail.com",true);
        Medlem mikkel = new Medlem("Mikkel Olsen",62,"næstfedesteko@gmail.com",false);
        System.out.println(martin.name +"\t\t" + martin.kontingent.beløb);
        System.out.println(mikkel.name +"\t\t\t" + mikkel.kontingent.beløb);
        System.out.println(martin.aktiveDiscipliner);
        System.out.println(mikkel.aktiveDiscipliner);
    }
}
