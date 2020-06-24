/*Ioanna Zournatzi*/

import java.util.ArrayList;
import java.util.Scanner;

public class Concerts extends Theamata {

    static ArrayList<Concerts> Sunaulia = new ArrayList<Concerts>();

    public Concerts(String title, String eidos, String start_date, int seats,float price) {
        super(title, eidos, start_date, seats,price);
    }
    static Scanner scan = new Scanner(System.in);
//συναρτηση για τη προσθηκη συναυλιων
    public static void addConcerts() {
        System.out.println("Add Concerts...");

        System.out.println("How many events do you want to add?");
        int loop = scan.nextInt();
        for (int i = 1; i <= loop; i++) {
            System.out.println("Vale titlo, eidos, start date, # theseis");
            title = scan.next();
            eidos = scan.next();
            start_date = scan.next();
            seats = scan.nextInt();
            price = scan.nextFloat();
            Concerts b = new Concerts(title, eidos, start_date, seats,price);
            System.out.println("Continue as a user?");
            String input = scan.next();
            if (input.equalsIgnoreCase("yes")) {
                User.login();
            }
        }

       
    }
    
    public static void addSunaulia(Concerts concert1, Concerts concert2)
    {
        Concerts.Sunaulia.add(concert1);
        Concerts.Sunaulia.add(concert1);
        
    
    }
//συναρτηση για τη διαγραφη συναυλιων
    public static void deleteconcert() {
        System.out.println("Enter the num of the events you want to delete");
        int loop = scan.nextInt();
        for (int i = 0; i < loop; i++) {
            System.out.println("Enter title");
            String titlos = scan.nextLine();
            for (int j = 0; j < Sunaulia.size(); j++) {
                if (Concerts.Sunaulia.get(j).title.equals(titlos)) {
                    Concerts.Sunaulia.remove(j);
                }
            }
        }
        System.out.println("Continue as a user?");
        String input = scan.next();
        if (input.equalsIgnoreCase("yes")) {
            User.login();
        }

    }

    public String toString() {
        return ("Title of event: " + title + "\nThe kind of the event: " + eidos + "\nStart day of the event" + start_date + "\nNum of seats" + seats + "/n Ticket price" + price);

    }
}
