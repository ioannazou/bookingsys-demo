/*ΙΩΑΝΝΑ ΖΟΥΡΝΑΤΖΗ 321/2017052
    ΑΣΚΗΣΗ 2, 2Η ΑΤΟΜΙΚΗ ΕΡΓΑΣΙΑ */

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Theater extends Theamata {

    public static ArrayList<Theater> Theatro = new ArrayList<Theater>();
    static Scanner scan = new Scanner(System.in);

    public Theater(String title, String eidos, String start_date, int seats, float price) {
        super(title, eidos, start_date, seats, price);
    }
//Συναρτηση στην οποια ο αδμιν μπορει να προσθεσει θεατρικες παραστασεις

    public static void TheaterEvents() {
        System.out.println("Add theater events");
        System.out.println("How many events do you want to add?");
        int loop = scan.nextInt();
        for (int i = 1; i <= loop; i++) {
            System.out.println("Vale titlo, eidos, start date, # theseis");
            title = scan.next();
            eidos = scan.next();
            start_date = scan.next();
            seats = scan.nextInt();
            Theater theatro = new Theater(title, eidos, start_date, seats, price);
            Theater.Theatro.add(theatro);
        }

    }
    
    public static void addTheatro( Theater theatrikiparastasi1,  Theater theatrikiparastasi2)
    {
        Theater.Theatro.add(theatrikiparastasi1);
        Theater.Theatro.add(theatrikiparastasi1);
        
    }    
//συναρτηση στην οποια ο admin διαγραφει οποια θεατρικη παρασταση θελει
    //βρισκοντας τη θεατρικη παρασταση με βαση τον τιτλο.

    public static void DeleteTheaterEvents() {
        System.out.println("Enter the num of the events you want to delete");
        int loop = scan.nextInt();
        for (int i = 0; i < loop; i++) {
            System.out.println("Enter title");
            String titlos = scan.next();
            for (int j = 0; j < Theatro.size(); j++) {
                if (Theater.Theatro.get(j).title.equals(titlos)) {
                    Theater.Theatro.remove(j);
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
        return ("Title of event: " + title + "\nThe kind of the event: " + eidos + "\nStart day of the event: " + start_date + "\nNum of seats:  " + seats);

    }

}
