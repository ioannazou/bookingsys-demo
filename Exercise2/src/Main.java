/*ΙΩΑΝΝΑ ΖΟΥΡΝΑΤΖΗ 321/2017052
    ΑΣΚΗΣΗ 2, 2Η ΑΤΟΜΙΚΗ ΕΡΓΑΣΙΑ */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String username = null;
        String password = null;
        Scanner scan = new Scanner(System.in);
        //αρχικα θα δημιουργησω καποιες εκδηλωσεις, ετσι ωστε αν θελει να συνδεθει ο χρηστης κατευθειαν
        //να υπαρχουν ηδη καποια event,ωστε να μπορει να κανει καποια κρατηση.
        //ΘΕΑΤΡΟ.
        Theater theatrikiparastasi1 = new Theater("Ainigma", "Drama", "12/12", 150, 14);
        Theater.Theatro.add(theatrikiparastasi1);
        Theater theatrikiparastasi2 = new Theater("Anthropoi kai Pontikia", "Koinwniko", "11/11", 75, 12);
        Theater.Theatro.add(theatrikiparastasi2);
        //ΣΥΝΑΥΛΙΕΣ. Ως τιτλος στις συναυλιες μπαινει το ονομα της μπαντας, τραγουδιστη.
        Concerts concert1 = new Concerts("Deep Purple", "Rock", "6/06/2020", 550, 45);

        Concerts concert2 = new Concerts("Red Hot Chili Peppers", "Rock", "5/06/2020", 420, 50);
        Concerts.addSunaulia(concert1, concert2);
        // Concerts.Sunaulia.add(concert2);
        //μενου επιλογων. πατωντας τον καθε αριθμο πηγαινει τον χρηστη ή αντιμ στη καθε λειτουργια που εχει επιλεξει.
        System.out.println("---MENU---");
        System.out.println("1. Sign up ");
        System.out.println("2. Login");
        System.out.println("3. Book a ticket");
        System.out.println("4. Admin");
        System.out.println("5. Exit");

        int answer = scan.nextInt();
        switch (answer) {
            case 1: {
                User.signup();
            }
            case 2: {
                User.login();
                Tickets.Ticket();

            }
            case 3: {
                Tickets.Ticket();
            }
            case 4: {
                User.Adminlogin(username, password);
                System.out.println("//ADMIN//");

                System.out.println("Access users or events?");
                String input = scan.next();
                if (input.equalsIgnoreCase("Users")) {
                    System.out.println("Enter the username of the user you want to delete");
                    String useranswer = scan.next();
                    for (int i = 0; i < User.Users.size(); i++) {
                        if (User.Users.get(i).username.equals(useranswer)) {
                            User.Users.remove(i); //θελει διαγραφη χρηστη με βαση το ονομα το user
                        }

                    }

                } else if (input.equalsIgnoreCase("Events")) {
                    System.out.println("Do you want to add or delete events?");
                    input = scan.next();
                    //αν συνδεθει ως αντιμ, επιλεγει την προσθηκη ή διαγραφη event. 
                    if (input.equalsIgnoreCase("Add")) {
                        System.out.println("Access Theater, Concerts, Athletic Events?");
                        input = scan.next();
                        if (input.equalsIgnoreCase("Theater")) {
                            System.out.println("Theater");
                            Theater.TheaterEvents();
                        }
                        if (input.equalsIgnoreCase("Concerts")) {
                            System.out.println("Concerts");
                            Concerts.addConcerts();
                        }
                        if (input.equalsIgnoreCase("Athletic Events")) {
                            System.out.println("Athletic Events");
                            AthleticEvents.addAthleticEvents();
                        }
                    }
                    if (input.equalsIgnoreCase("Delete")) {
                        System.out.println("Access Theater, Concerts, Athletic Events?");
                        input = scan.next();
                        if (input.equalsIgnoreCase("Theater")) {
                            System.out.println("Theater");
                            Theater.DeleteTheaterEvents();
                        }
                        if (input.equalsIgnoreCase("Concerts")) {
                            System.out.println("Concerts");
                            Concerts.deleteconcert();
                        }
                        if (input.equalsIgnoreCase("Athletic Events")) {
                            System.out.println("Athletic Events");
                            AthleticEvents.DeleteAthleticEvents();
                        }
                    }
                }
            }

            case 5: { //εξοδος απο το προγραμμα.
                return;
            }
        }
    }
}
