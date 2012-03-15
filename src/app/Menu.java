package app;
import java.util.Scanner;

public class Menu
{
    public void printTitle()
    {
        System.out.println("---------------------\n"
                + "| Jasmine's P2P App |\n"
                + "---------------------\n");
    }

    public void printMenu()
    {
        System.out.println("Enter a number...\n"
                + "1) Start chatting\n"
                + "2) Start playing\n");
    }

    public String getMenuChoice()
    {
        Scanner scan = new Scanner(System.in);

        String choice = scan.nextLine();
        while (!choice.equals("1") || !choice.equals("2"))
        {
            System.out.println("ERROR: Please enter either 1 or 2.");
            printMenu();
            choice = scan.nextLine();
        }

        return choice;
    }

    public void openWindow(String choice)
    {
        if (choice.equals("1"))
        {
            // print confirmation
            // open chat window
        }

        if (choice.equals("2"))
        {
            // print confirmation
            // open game window
        }
    }

}
