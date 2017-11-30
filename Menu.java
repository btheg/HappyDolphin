/*
import java.util.Scanner;

// Authors Kasper og Matias
public class Menu
{
    private SvømmerListe svømmerListe = new SvømmerListe();
    private HoldListe holdListe = new HoldListe();
    private DisciplinListe discipliner = new DisciplinListe();
    private Scanner scanner = new Scanner(System.in);
    private FileHandler fh = new FileHandler();

    public Menu()
    {
    }


    public void menuLogin()
    {
        discipliner.init();
        svømmerListe.setSvømmere(fh.readSvømmerListe("svoemmere.txt"));
        holdListe.setHold(fh.readHoldListe("hold.txt"));
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
                    "5. Se Hold\n" +
                    "6. Gem Medlemmer\n" +
                    "Tryk på enhver anden knap for at lukke programmet");

            String valg = scanner.next();
            switch (valg)
            {
                case "1":
                    System.out.println("Indtast medlemmets navn");
                    scanner.nextLine();
                    String navn = scanner.nextLine();

                    System.out.println("Indtast medlemmets Email");
                    String email = scanner.nextLine();
                    boolean wronginput = true;
                    int alder = 0;
                    boolean konkurrence = true;
                    while (wronginput)
                    {
                        try
                        {
                            //scanner.nextLine();
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
                        for (int i = 0; i < holdListe.getHold().size(); i++)
                        {
                            if(nytmedlem.isKonkurrence()== holdListe.getHold().get(i).isKonkurrence())
                            {
                                if(nytmedlem.getAlder()<18 && holdListe.getHold().get(i).isJunior()||
                                        nytmedlem.getAlder()>=18 && !holdListe.getHold().get(i).isJunior())
                                System.out.println(i + ". " + holdListe.getHold().get(i).getNavn());
                            }
                        }
                        try
                        {
                            scanner.nextLine();
                            int choice = scanner.nextInt();
                            if (holdListe.getHold().get(choice) != null)
                            {
                                //Tilføjer kun hvis parametrene passer
                                svømmerListe.tilføjSvømmer(nytmedlem, holdListe.getHold().get(choice));
                                if(nytmedlem.isKonkurrence()== holdListe.getHold().get(choice).isKonkurrence())
                                {
                                    if(nytmedlem.getAlder()<18 && holdListe.getHold().get(choice).isJunior()||
                                            nytmedlem.getAlder()>=18 && !holdListe.getHold().get(choice).isJunior())
                                        //Stopper loopet
                                        holdErIListen = true;
                                }
                            }
                        } catch (Exception e)
                        {
                            System.out.println("Det skal være et tal fra listen!");
                        }
                    }
                    System.out.println("Tryk enter for at komme videre");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case "2":
                    System.out.println(holdListe.getHold());
                    System.out.println("\nSøg på medlem via mail:");
                    scanner.nextLine();
                    String søgMail = scanner.nextLine();
                    Svømmer rediger = svømmerListe.getViaMail(søgMail);
                    if (rediger != null)
                    {
                        System.out.println("Du er i gang med at redigere medlemsskab for " + rediger.navn);
                        System.out.println("\nTryk 1 for at redigere konkurrence status" +
                                "\nTryk 2 for at redigere medlemsskabsstatus");
                        String firstChoice = scanner.nextLine();
                        switch(firstChoice)
                        {
                            case "1":
                                System.out.println(rediger);
                                if(rediger.isKonkurrence())
                                {
                                    System.out.println(rediger.navn + " er lige nu konkurrence svømmer.\n" +
                                            "hvis det ikke skal ændres skriv: true\n" +
                                            "hvis vedkommende skal være motionist svømmer skriv: false");
                                } else
                                {
                                    System.out.println(rediger.navn + " er lige nu motionist svømmer.\n" +
                                            "hvis det ikke skal ændres skriv: false\n" +
                                            "hvis vedkommende skal være konkurrence svømmer skriv: true");
                                }
                                boolean wronginput2 = true;
                                while(wronginput2)
                                {
                                    try
                                    {
                                        boolean nykonkurrence = scanner.nextBoolean();
                                        rediger.setKonkurrence(nykonkurrence);
                                        wronginput2 = false;
                                    }
                                    catch(Exception e)
                                    {
                                        System.out.println("Du skal skrive true eller false");
                                        scanner.nextLine();
                                    }
                                }
                                boolean holdSkift = false;
                                while(!holdSkift)
                                {
                                    System.out.println("Vælg et hold til " + rediger.navn +
                                            "\nIndtast nummeret for ønskede hold: ");
                                    for (int i = 0; i < holdListe.getHold().size(); i++)
                                    {
                                        if(rediger.isKonkurrence()== holdListe.getHold().get(i).isKonkurrence())
                                        {
                                            if(rediger.getAlder()<18 && holdListe.getHold().get(i).isJunior()||
                                                    rediger.getAlder()>=18 && !holdListe.getHold().get(i).isJunior())
                                                System.out.println(i + ". " + holdListe.getHold().get(i).getNavn());
                                        }
                                    }
                                    try
                                    {
                                        scanner.nextLine();
                                        int choice = scanner.nextInt();
                                        if (holdListe.getHold().get(choice) != null)
                                        {
                                            if(rediger.isKonkurrence()== holdListe.getHold().get(choice).isKonkurrence())
                                            {
                                                if(rediger.getAlder()<18 && holdListe.getHold().get(choice).isJunior()||
                                                        rediger.getAlder()>=18 && !holdListe.getHold().get(choice).isJunior())
                                                {
                                                    holdListe.skiftHold(rediger, holdListe.getHold().get(choice));
                                                    holdSkift = true;
                                                } else
                                                {
                                                    System.out.println("Det skal være et tal fra listen");
                                                }

                                            } else
                                            {
                                                System.out.println("Det skal være et tal fra listen!");
                                            }
                                        }
                                    } catch (Exception e)
                                    {
                                        System.out.println("Det skal være et tal fra listen fejl!");
                                    }
                                } break;
                            case "2":
                                try
                                {
                                    boolean activeChoice;
                                    if (rediger.getKontingent().isAktiv())
                                    {
                                        System.out.println(rediger.navn + "'s medlemsskab er aktivt." +
                                                "\nHvis det skal blive ved med det skriv:   true" +
                                                "\nHvis det skal ændres til passivt skriv:  false");
                                        activeChoice = scanner.nextBoolean();
                                        rediger.redigerActive(activeChoice);
                                        holdListe.redigerActive(activeChoice,rediger);
                                        if(activeChoice)
                                        {
                                            System.out.println(rediger.navn + "'s medlemsskab er nu aktivt");
                                        }
                                        else
                                        {
                                            System.out.println(rediger.navn + "'s medlemsskab er nu passivt");
                                        }


                                    }
                                    else
                                    {
                                        System.out.println(rediger.navn + "'s medlemskab er passivt." +
                                                "\nHvis det skal blive ved med det skriv:   false" +
                                                "\nHvis det skal ændres til aktivt skriv:   true");
                                        activeChoice = scanner.nextBoolean();
                                        rediger.redigerActive(activeChoice);
                                        holdListe.redigerActive(activeChoice,rediger);
                                        if(activeChoice)
                                        {
                                            System.out.println(rediger.navn + "'s medlemsskab er nu aktivt");
                                        }
                                        else
                                        {
                                            System.out.println(rediger.navn + "'s medlemsskab er nu passivt");
                                        }

                                    }
                                } catch (Exception e)
                                {
                                    System.out.println("Du SKAL skrive true eller false");
                                } break;
                            default:
                                System.out.println("Du skal skrive 1 eller 2\n");
                        }



                    } else
                    {
                        System.out.println("Der er ikke nogen svømmer med den mail.");
                    }
                    System.out.println("Tryk enter for at komme videre");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case "3":
                    //Find medlem via mail
                    boolean isMedlem = false;
                    scanner.nextLine();
                    boolean quit = false;
                    while (!isMedlem)
                    {
                        System.out.println("Medlemmer: ");
                        System.out.println(svømmerListe.getSvømmere());
                        System.out.println("\nSkriv emailen, på medlemmet du ønsker at slette, \n" +
                                "eller q for at komme tilbage til menuen");
                        String mail = scanner.nextLine();
                        if (mail.toLowerCase().equals("q"))
                        {
                            quit = true;
                            break;
                        }

                            else if (svømmerListe.getViaMail(mail) != null)
                            {
                                holdListe.sletSvømmer(svømmerListe.getViaMail(mail));
                                svømmerListe.getSvømmere().remove(svømmerListe.getViaMail(mail));
                                isMedlem = true;
                            } else
                            {
                                System.out.println("Der er ikke noget medlem med den mail");
                                //scanner.nextLine();
                            }
                        }
                    if(!quit)
                    {
                        System.out.println("Medlemmet er nu blevet slettet!\n" +
                                "Tryk enter for at komme videre");
                        scanner.nextLine();
                    }
                    break;
                case "4":
                    System.out.println(svømmerListe.getSvømmere());
                    System.out.println("\nTryk enter for at komme videre");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case "5":
                    System.out.println(holdListe.getHold());
                    System.out.println("\nTryk enter for at komme videre");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case "6":
                    fh.writeSvømmerList(svømmerListe.getSvømmere(),"svoemmere.txt");
                    fh.writeHoldList(holdListe.getHold(),"hold.txt");
                    System.out.println("Medlemmer og hold er nu gemt.");
                    System.out.println("\n\nTryk enter for at komme videre");
                    scanner.nextLine();
                    scanner.nextLine();
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
                    for (int i = 4; i < holdListe.getHold().size(); i++)
                    {
                        System.out.println(holdListe.getHold().get(i));

                    }
                    System.out.println("\nTryk enter for at komme videre");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case "3":
                    break;
                case "4":

                    boolean disciplinerErPåListen = false;
                    while(!disciplinerErPåListen)
                    {
                        System.out.println("Hvilken diciplin vil du se top 5 af?");
                        for (int i = 0; i < discipliner.getDiscipliner().size(); i++)
                        {

                            System.out.println(i + ". " + discipliner.getDiscipliner().get(i).getType());
                        }
                        try
                        {
                            scanner.nextLine();
                            int choice = scanner.nextInt();
                            if (discipliner.getDiscipliner().get(choice) != null)
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
}*/