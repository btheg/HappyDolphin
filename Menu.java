import java.util.Scanner;

// Authors Kasper og Matias
public class Menu
{
    private SvømmerListe svømmerListe = new SvømmerListe();
    private HoldListe hold = new HoldListe();
    private DisciplinListe discipliner = new DisciplinListe();
    private Scanner scanner = new Scanner(System.in);

    public Menu()
    {
    }


    public void menuLogin()
    {
        hold.init();
        discipliner.init();

        Ansat ansat1 = new Ansat("Ole", "mail", 20, "Formand", "123");
        Ansat ansat2 = new Ansat("Gert", "mail", 40, "Kasserer", "123");
        Ansat ansat3 = new Ansat("John", "mail", 55, "Træner", "123");

        // Welcome Message
        System.out.println("Velkommen til svømmeklubben Delfinen");

        // Login
        boolean korrektlogin = false;
        while (!korrektlogin)
        {
            System.out.println("Indtast brugernavn");
            String korrektEmail = scanner.nextLine();

            if (ansat1.getUserName().equals(korrektEmail))
            {
                System.out.println("Enter Password");
                String korrektPassword = scanner.nextLine();

                if (ansat1.getPassWord().equals(korrektPassword))
                {
                    korrektlogin = true;
                    // Formandens Menu
                    this.formandMenu();

                }
            }

            if (ansat2.getUserName().equals(korrektEmail))
            {
                System.out.println("Enter Password");
                String korrektPassword = scanner.nextLine();

                if (ansat2.getPassWord().equals(korrektPassword))
                {
                    korrektlogin = true;
                    // Kasserer menu
                    this.kasserMenu();
                }
            }


            if (ansat3.getUserName().equals(korrektEmail))
            {
                System.out.println("Enter Password");
                String korrektPassword = scanner.nextLine();

                if (ansat3.getPassWord().equals(korrektPassword))
                {
                    korrektlogin = true;
                    // Træner menu
                    this.trænerMenu();
                }
            }


        }
    }

    public void formandMenu()
    {
        boolean isRunningFormand = true;
        while (isRunningFormand)
        {

            System.out.println("Menu\n" +
                    "1. Opret Medlem\n" +
                    "2. Rediger Medlemskab\n" +
                    "3. Slet Medlem \n" +
                    "4. Se Medlemmer\n" +
                    "Press any other key to exit");

            String valg = scanner.next();
            switch (valg)
            {
                case "1":
                    System.out.println("Indtast medlemmets navn");
                    String navn = scanner.next();

                    System.out.println("Indtast medlemmets Email");
                    String email = scanner.next();
                    boolean wronginput = true;
                    int alder = 0;
                    boolean konkurrence = true;
                    while (wronginput)
                    {
                        try
                        {
                            scanner.nextLine();
                            System.out.println("Indtast medlemmets alder");
                            alder = scanner.nextInt();

                            System.out.println("Er medlemmet konkurrencesvømmer? Skriv true/false");
                            konkurrence = scanner.nextBoolean();
                            wronginput = false;
                        } catch (Exception e)
                        {
                            System.out.println("Alderen skal være et heltal, og konkurrence SKAL være true/false");
                        }
                    }
                    boolean rigtigthold = false;
                    Svømmer nytmedlem = new Svømmer(navn, email, alder, konkurrence);
                    boolean holdErIListen = false;


                    while (!holdErIListen)
                    {
                        System.out.println("Indtast nummeret for ønskede hold: ");
                        for (int i = 0; i < hold.hold.size(); i++)
                        {
                            System.out.println(i + ". " + hold.hold.get(i).navn);
                        }
                        try
                        {
                            scanner.nextLine();
                            int choice = scanner.nextInt();
                            if (hold.hold.get(choice) != null)
                            {
                                svømmerListe.tilføjSvømmer(nytmedlem, hold.hold.get(choice));
                                holdErIListen = true;
                            }
                        } catch (Exception e)
                        {
                            System.out.println("Det skal være et tal fra listen!");
                        }
                    }

                    System.out.println(navn + " er nu oprettet i systemet");
                    System.out.println();


                    // TEST System.out.println(medlemmer);


                    break;
                case "2":
                    break;
                case "3":
                    //Find medlem via mail
                    boolean isMedlem = false;
                    scanner.nextLine();
                    while (!isMedlem)
                    {
                        System.out.println("Medlemmer: ");
                        System.out.println(svømmerListe.svømmere);
                        System.out.println("Skriv emailen, på medlemmet du ønsker at slette:");
                        String mail = scanner.nextLine();
                        if (svømmerListe.getViaMail(mail) != null)
                        {
                            svømmerListe.svømmere.remove(svømmerListe.getViaMail(mail));
                            isMedlem = true;
                        } else
                        {
                            System.out.println("Der er ikke noget medlem med den mail");
                            //scanner.nextLine();
                        }
                    }
                    System.out.println("Medlemmet er nu blevet slettet!\n" +
                            "Tryk enter for at komme videre");
                    scanner.nextLine();
                    break;
                case "4":
                    System.out.println(svømmerListe.svømmere);
                    break;
                default:
                    isRunningFormand = false;
                    break;
            }
        }
    }

    public void kasserMenu()
    {
        boolean isRunning = true;
        while (isRunning)
        {
            System.out.println("Menu\n" +
                    "1. Rediger Medlemskab\n" +
                    "2. Se betalingsoversigt\n" +
                    "3. Se Medlemmer\n" +
                    "Press any other key to exit");

            String valg = scanner.next();
            switch (valg)
            {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    isRunning = false;
                    break;
            }
        }
    }

    public void trænerMenu()
    {
        boolean isRunningTræner = true;
        while (isRunningTræner)
        {
            System.out.println("Menu\n" +
                    "1. Registrer resultater\n" +
                    "2. Se Konkurrence Svømmere\n" +
                    "3. Se Rangliste\n" +
                    "4. Top 5\n" +
                    "Press any other key to exit");

            String valg = scanner.next();
            switch (valg)
            {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":

                    boolean disciplinerErPåListen = false;
                    while(!disciplinerErPåListen)
                    {
                        System.out.println("Hvilken diciplin vil du se top 5 af?");
                        for (int i = 0; i < discipliner.discipliner.size(); i++)
                        {

                            System.out.println(i + ". " + discipliner.discipliner.get(i).type);
                        }
                        try
                        {
                            scanner.nextLine();
                            int choice = scanner.nextInt();
                            if (discipliner.discipliner.get(choice) != null)
                            {

                                disciplinerErPåListen = true;
                            }
                        } catch (Exception e)
                        {
                            System.out.println("Det skal være en disciplin fra listen!");
                        }
                    }
                    break;
                default:
                    isRunningTræner = false;
                    break;
            }
        }
    }
}