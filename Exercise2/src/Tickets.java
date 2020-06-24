/*Ioanna Zournatzi*/

import java.util.Scanner;
import java.util.ArrayList;

public class Tickets {

    private static String title;
    private static String eidos;
    private static String start_date;
    private static int seats;
    private static String surname;
    private static String name;
    private static float price;
    static Scanner scan = new Scanner(System.in);
    int num = 3;
    public static ArrayList<Tickets> tickets = new ArrayList<>();
    static int numoftickets = 0;

    public Tickets(String title, String start_date, String name, String surname, int seats, float price) {
        this.title = title;
        this.start_date = start_date;
        this.name = name;
        this.surname = surname;
        this.seats = seats;
        this.price = price;
    }

    public static void Ticket() {
        User.login(); //αρχικα ο χρηστης συνδεεται
        //Στη συνεχεια, το συστημα του δινει την επιλογη κρατησης ή ακυρωσης.

        System.out.println("Do you want to book a ticket for an event or cancel an already purchased ticket?");
        String answer = scan.next();
        if (answer.equalsIgnoreCase("book")) { //Αν επιλεξει κρατηση, μετα επιλεγει αναμεσα σε θεατρο, συναυλιες ή καποιο αθλητικο ιβεντ

            System.out.println("Enter the kind of the event. Available: Theater, Concert, Athletic Event");
            String answer2 = scan.next();
            if (answer2.equalsIgnoreCase("Theater")) {
                //show available events
                for (int i = 0; i < Theater.Theatro.size(); i++) {
                    System.out.println(Theater.Theatro.get(i).title + Theater.Theatro.get(i).start_date);

                    System.out.println("Enter the title of the event");
                    String titlos = scan.next();
                    //choose the event
                    if (Theater.Theatro.get(i).title.equalsIgnoreCase(titlos)) {
                        System.out.println("How many tickets do you want?");
                        numoftickets = scan.nextInt();
                        for (int j = 0; j < numoftickets; j++) {

                            System.out.println("Enter the name, surname, credit card num");
                            String name = scan.next();
                            String surname = scan.next();
                            String creditcard = scan.next();
                        //    String start_date = scan.next();
                            
                            int seats = scan.nextInt();
                            if (Theater.Theatro.get(i).seats <  numoftickets) {
                                System.out.println("There are not enough available seats");
                                return;
                            } else {
                                Tickets eisitirio = new Tickets(titlos, start_date, name, surname, seats, price);
                                Theater.Theatro.get(i).seats = Theater.Theatro.get(i).seats - seats;
                                System.out.println("The price of the tickets..." + numoftickets*price);
                            }
                        }

                    }
                }
            } else if (answer2.equalsIgnoreCase("Concert")) {
                //show available events  
                for (int i = 0; i < Concerts.Sunaulia.size(); i++) {
                    System.out.println(Concerts.Sunaulia.get(i).title + Concerts.Sunaulia.get(i).start_date);

                    String titlos = scan.nextLine();
                    if (Concerts.Sunaulia.get(i).title.equalsIgnoreCase(titlos)) {
                        System.out.println("How many tickets do you want?");
                        numoftickets = scan.nextInt();

                        for (int j = 0; j < numoftickets; j++) {

                            System.out.println("Enter the name, surname, credit card num");
                            String name = scan.next();
                            String surname = scan.next();
                            String creditcard = scan.next();
                           // String start_date = scan.next();
//                            int seats = scan.nextInt();
                            if (Concerts.Sunaulia.get(i).seats < numoftickets) {
                                System.out.println("There are not enough available seats");
                                return;
                            } else {
                                Tickets eisitirio = new Tickets(titlos, start_date, name, surname, numoftickets, price);
                                Concerts.Sunaulia.get(i).seats = Concerts.Sunaulia.get(i).seats - numoftickets;
                                System.out.println("The price of the tickets..." + numoftickets*price);
                            }
                        }
                    }
                }
            } else if (answer2.equalsIgnoreCase("Athletic Event")) {
                  //show available events
                for (int i = 0; i < AthleticEvents.AthlitikaEvent.size(); i++) {
                    System.out.println(AthleticEvents.AthlitikaEvent.get(i).title + AthleticEvents.AthlitikaEvent.get(i).start_date);
                    //choose the event
                    String titlos = scan.next();
                   
                    if (AthleticEvents.AthlitikaEvent.get(i).title.equalsIgnoreCase(titlos)) {
                        System.out.println("How many tickets do you want?");
                    }
                    numoftickets = scan.nextInt();

                    for (int j = 0; j < numoftickets; j++) {

                        System.out.println("Enter the name, surname, credit card num");
                        String name = scan.next();
                        String surname = scan.next();
                        String creditcard = scan.next();
                 //       String start_date = scan.next();
                       // int seats = scan.nextInt();
                        if (AthleticEvents.AthlitikaEvent.get(i).seats < numoftickets) {
                            System.out.println("There are not enough available seats");
                            return;
                        } else {
                            Tickets eisitirio = new Tickets(titlos, start_date, name, surname, numoftickets, price);
                            AthleticEvents.AthlitikaEvent.get(i).seats = AthleticEvents.AthlitikaEvent.get(i).seats - numoftickets;
                            System.out.println("The price of the tickets..." + numoftickets*price);
                        }
                    }
                }
            }
//αν ο χρηστης επιλεξει ακυρωση καποιας κρατησης, πληκτρολογει το επωνυμο που ειχε προσθεσει στη κρατηση, το βρισκει στη λιστα 
//που ειναι αποθηκευμενο , αφαιρει απο τη παρασταση//event τον αριθμο των κρατημενων θεσεων και τον διαγραφει απο τη λιστα των κρατησεων.
        } else if (answer.equalsIgnoreCase("cancel")) {
            System.out.println("Enter the kind of the event. Theater, Concert, Athletic Events ");
            String input = scan.next();
            if (input.equalsIgnoreCase("Theater")) {
                System.out.println("Enter the surname of the reservation..");
                String input2 = scan.next();

                for (int i = 0; i < Tickets.tickets.size(); i++) {
                    if (Tickets.tickets.get(i).surname.equalsIgnoreCase(input)) {
                        Theater.Theatro.get(i).seats = Theater.Theatro.get(i).seats + Tickets.tickets.get(i).seats;
                        Tickets.tickets.remove(i);
                        System.out.println("You successfully canceled your reservation");
                    } else {
                        return;
                    }

                }
            }
            if (input.equalsIgnoreCase("Concert")) {
                System.out.println("Enter the surname of the reservation..");
                String input2 = scan.next();

                for (int i = 0; i < Tickets.tickets.size(); i++) {
                    if (Tickets.tickets.get(i).surname.equalsIgnoreCase(input)) {
                        Theater.Theatro.get(i).seats = Concerts.Sunaulia.get(i).seats + Theater.Theatro.get(i).seats;
                        Tickets.tickets.remove(i);
                        System.out.println("You successfully canceled your reservation");
                    }

                }

            }
            if (input.equalsIgnoreCase("Athletic Events")) {
                System.out.println("Enter the surname of the reservation..");
                String input2 = scan.next();
                for (int i = 0; i < AthleticEvents.AthlitikaEvent.size(); i++) {
                    if (Tickets.tickets.get(i).surname.equalsIgnoreCase(input)) {
                        AthleticEvents.AthlitikaEvent.get(i).seats = AthleticEvents.AthlitikaEvent.get(i).seats + Tickets.tickets.get(i).seats;
                        Tickets.tickets.remove(i);
                        System.out.println("You successfully canceled your reservation");
                    } else {
                        return;
                    }

                }

            }

        }
    }
}
