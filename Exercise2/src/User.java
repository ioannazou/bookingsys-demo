/*ΙΩΑΝΝΑ ΖΟΥΡΝΑΤΖΗ 321/2017052
    ΑΣΚΗΣΗ 2, 2Η ΑΤΟΜΙΚΗ ΕΡΓΑΣΙΑ */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class User {

    protected static String username;
    private static String password;
    private static String number;
    private static String email;
    private static String name;
    private static String birthdate;

    public static ArrayList<User> Users = new ArrayList<>();

    public User(String username, String password, String name, String number, String email, String birthdate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.number = number;
        this.email = email;
        this.birthdate = birthdate;
    }
//συναρτηση που οριζει το username kai to password tou admin,και μπορει να συνδεθει μονο με αυτα.
    public static void Adminlogin(String username, String password) {
        username = "admin";
        password = "Pass123";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username + password");
        String adminusername = scan.next();
        String adminpassword = scan.next();
        if (adminusername.equals(username) && adminpassword.equals(password)) {
            System.out.println("Successfull login");

        } else {
            System.out.println("Wrong username or password");
            Adminlogin(username,password);
        }
    }
//συναρτηση για εγγραφη χρηστη
    //δεχεται ολα τα απαιτουμενα στοιχεια, και τα αποθηκευει σε αρχειο, και σε λιστα.
    //στο αρχειο απλα αποθηκευονται τα αρχεια, δε χρησιμοποιουνται πουθενα.
    public static void signup() {

        BufferedWriter bw = null;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Username: ");
        username = keyboard.next();

        System.out.println("Password: ");
        password = keyboard.next();

        System.out.println("Enter your email: ");
        email = keyboard.next();

        System.out.println("Enter your birth date: ");
        birthdate = keyboard.next();

        System.out.println("Enter your number");
        number = keyboard.next();

        User xristes = new User(username, password, name, email, birthdate, number);
        try {
            File file = new File("C:\\Users\\Ioanna\\Desktop\\test.txt");

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write("Username " + "  " + "Password " + "  " + "Email " + "  " + "Birthdate " + "  " + "Number " + "\n \n");
            bw.write(username + "    " + password + "    " + email + "    " + birthdate + "    " + number);
            System.out.println("File written Successfully");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }

        }
//μπορει να κανει εγγραφη και αλλος χρηστης
        System.out.println("Do you want to register another user?");
        String reg = keyboard.next();
        if (reg.equalsIgnoreCase("yes")) {
            signup();

        } else if (reg.equalsIgnoreCase("no")) {
            login();
        }
    }
//απο αυτη τη συναρτηση ο χρηστης μπορει να συνδεθει.
    //ελεγχει το username & password απο τη λιστα που εχουν αποθηκευτει.
    public static void login() {

        System.out.println("Are you already a user?");
        Scanner ans = new Scanner(System.in);
        String answer = ans.next();

        if (answer.equals("yes")) {

            System.out.println("Enter your username");
            String userans1 = ans.next();

            System.out.println("Enter your password");
            String userans2 = ans.next();

            for (int i = 0; i < Users.size(); i++) {
                if (User.Users.get(i).username.equals(userans1)) {
                    if (User.Users.get(i).password.equals(userans2)) {
                        System.out.println("Correct username & password");
                        System.out.println("Continue with booking or canceling a ticket?");
                        answer = ans.next();
                        if (answer.equalsIgnoreCase("yes")) {
                            Tickets.Ticket();
                        }
                    } else {
                        System.out.println("Wrong username");
                    }
                }
            }
        } else {
            signup();
        }
        
        System.out.println("Do you want to delete your account");
        String answer3 = ans.next();
        if(answer3.equalsIgnoreCase("yes"))
        {
            DeleteUser();
        }

    }
//μπορει να διαβαστει το αρχειο απο εδω. εν τελει, δε χρησιμοποιηθηκε πουθενα.
    public static void readFile() throws IOException {

        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader("C:\\Users\\Ioanna\\Desktop\\test.txt"));

        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            // Split line on comma.
            String[] parts = line.split(",");
            for (String part : parts) {
                System.out.println(part);
            }
            System.out.println();
        }

        reader.close();

    }
    
    public static void DeleteUser()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the username of the user you want to delete");
        String user = keyboard.next();
        
        for(int i=0; i<Users.size(); i++)
        {
            if(User.Users.get(i).username.equalsIgnoreCase(user))
            {
                User.Users.remove(i);
            }
        }
        
    
    }
}
