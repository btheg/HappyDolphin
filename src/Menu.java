import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class Menu
{
    public Menu()
    {
    }


    public void menu() {
        Scanner scanner = new Scanner(System.in);

        Ansat ansat1 = new Ansat("Ole","mail",20,"Formand","123");
        Ansat ansat2 = new Ansat("Gert","mail",40,"Kasserer","123");
        Ansat ansat3 = new Ansat("John","mail",55,"Træner","123");

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

                if (ansat1.getPassWord().equals(korrektPassword)){
                    korrektlogin = true;
                }
            }
        }

        // Formandens Menu

        boolean isRunning = true;
        while (isRunning) {

            System.out.println("Menu\n" +
            "1. Opret Medlem\n" +
            "2. Rediger Medlemskab\n" +
            "3. Slet Medlem \n" +
            "Press any other key to exit");

            String valg = scanner.next();
            switch(valg)
            {
                case "1":
                    System.out.println("Indtast medlemmets navn");
                    String navn = scanner.next();

                    System.out.println("Indtast medlemmets Email");
                    String email = scanner.next();

                    System.out.println("Indtast medlemmets alder");
                    int alder = scanner.nextInt();

                    System.out.println(navn + " er nu oprettet i systemet");
                    System.out.println();

                    Medlem nytmedlem = new Medlem(navn,email,alder);

                    ArrayList<Medlem> medlemmer = new ArrayList<>();

                    medlemmer.add(nytmedlem);

                    // TEST System.out.println(medlemmer);


                    break;
            }
        }



        }




}

