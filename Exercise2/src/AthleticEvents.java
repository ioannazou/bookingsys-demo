/*Ioanna Zournatzi*/

import java.util.ArrayList;
import java.util.Scanner;

public class AthleticEvents extends Theamata {

    static ArrayList<AthleticEvents> AthlitikaEvent = new ArrayList<AthleticEvents>();

    public AthleticEvents(String title, String eidos, String start_date, int seats,float price) {
        super(title, eidos, start_date, seats,price);
    }
    static Scanner scan = new Scanner(System.in);
 
    
//προσθηκη αθλητικων event
    public static void addAthleticEvents() {
        System.out.println("How many events do you want to add?");
        int loop = scan.nextInt();
        for (int i = 1; i <= loop; i++) {
            System.out.println("Vale titlo, eidos, start date, # theseis");
            title = scan.nextLine();
            eidos = scan.nextLine();
            start_date = scan.nextLine();
            seats = scan.nextInt();
            AthleticEvents c = new AthleticEvents(title, eidos, start_date, seats,price);

        }
        
        System.out.println("Continue as a user?");
        String input = scan.next();
        if(input.equalsIgnoreCase("yes"))
        {
            User.login();
        }

    }
//διαγραφη αθλητικων event
    public static void DeleteAthleticEvents() {
        System.out.println("Enter the num of the events you want to delete");
        int loop = scan.nextInt();
        for (int i = 0; i < loop; i++) {
            System.out.println("Enter title");
            String titlos = scan.nextLine();
            for (int j = 0; j < AthlitikaEvent.size(); j++) {
                if (AthleticEvents.AthlitikaEvent.get(j).title.equals(titlos)) {
                    AthleticEvents.AthlitikaEvent.remove(j);
                }
            }
        }
          System.out.println("Continue as a user?");
        String input = scan.next();
        if(input.equalsIgnoreCase("yes"))
        {
            User.login();
        }
    }

    public String toString() {
        return ("\nTitle of event: " + title + "\nThe kind of the event: " + eidos + "\nStart day of the event" + start_date + "\nNum of seats" + seats);

    }
}
