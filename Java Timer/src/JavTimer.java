import java.util.Scanner;

public class JavTimer {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanz = new Scanner(System.in);
        boolean repeat = true;

        System.out.println("Welcome to JavTimer!");
        System.out.println("Input Time Below (Max hours: 23 | Max minutes & seconds: 59 | Enter 0 to keep blank)");

        while (repeat) { 
            int hours, mins, secs;


            while (true) {
                System.out.print("Enter Hours: ");
                hours = scanz.nextInt();

                System.out.print("Enter Minutes: ");
                mins = scanz.nextInt();

                System.out.print("Enter Seconds: ");
                secs = scanz.nextInt();

                if (hours < 0 || hours > 23 || mins < 0 || mins > 59 || secs < 0 || secs > 59) {
                    System.out.println("Invalid input! Please try again.");
                    continue;
                }
                break; 
            }


            while (hours > 0 || mins > 0 || secs > 0) {
                System.out.printf("\r%02d:%02d:%02d", hours, mins, secs);
                Thread.sleep(1000);

                if (secs > 0) {
                    secs--;
                } else if (mins > 0) {
                    secs = 59;
                    mins--;
                } else if (hours > 0) {
                    mins = 59;
                    secs = 59;
                    hours--;
                }
            }

            System.out.println("\rTime's up!");

            System.out.print("Do you want to input another time? (Y/N): ");
            char choice = scanz.next().charAt(0);
            
            if (choice == 'Y' || choice == 'y') {
                repeat = true; 
            } else if (choice == 'N' || choice == 'n') {
                repeat = false; 
            }
        }

        System.out.println("Thanks for using JavTimer"); 
    }
}
