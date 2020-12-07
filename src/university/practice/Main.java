package university.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Rajat Biswas
 * Dated: 07-12-2020
 * Do not modify.
 * */
public class Main {

    /*
    * Write a menu driven java program to implement AND, OR, NOT, N-AND and NOR gates
    * using exception handling
    * */
    public static void main(String[] args) {
        //Using try with resources.
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            printMenu();

            //Choice list
            final byte EXIT = 0;        //This choice will exit the program.
            final byte REPRINT = 1;     //This choice will invoke the printMenu() method.
            final byte AND = 2;         //Choice that will give out AND.
            final byte OR = 3;          //Choice that will give out OR.
            final byte NOT = 4;         //Choice that will give out NOT.
            final byte N_OR = 5;        //Choice that will give out N_OR.
            final byte N_AND = 6;       //Choice that will give out N_AND.

            //Loop will iterate until exit value is modified.
            while (!exit) {
                System.out.print("Choice: ");
                int choice = scanner.nextInt();

                int x;
                int y;
                switch (choice) {
                    case EXIT:
                        exit = true;    //Upon pressing it'll update exit to true i.e. loop will stop iterating.
                        System.out.println("Application exited.");
                        break;
                    case REPRINT:
                        printMenu();    //Calls the printMenu() method.
                        break;
                    case AND:
                        System.out.print("Enter X = ");
                        x = scanner.nextInt();
                        System.out.print("Enter Y = ");
                        y = scanner.nextInt();

                        //AND is done by utilizing bitwise AND(&)
                        System.out.println(x + " AND " + y + " is " + (x & y) + " (decimal).");
                        System.out.println(Integer.toBinaryString(x) + " AND " + Integer.toBinaryString(y)
                                + " is " + Integer.toBinaryString(x & y) + " (binary).");
                        break;
                    case OR:
                        System.out.print("Enter X = ");
                        x = scanner.nextInt();
                        System.out.print("Enter Y = ");
                        y = scanner.nextInt();

                        //AND is done by utilizing bitwise OR(|)
                        System.out.println(x + " OR " + y + " is " + (x | y) + " (decimal).");
                        System.out.println(Integer.toBinaryString(x) + " OR " + Integer.toBinaryString(y)
                                + " is " + Integer.toBinaryString(x | y) + " (binary).");
                        break;
                    case NOT:
                        System.out.print("Enter a number = ");
                        x = scanner.nextInt();

                        //AND is done by utilizing bitwise NOT/1'S COMPLEMENT(~)
                        System.out.println("NOT of " + x + " is " + ~x + " (decimal).");
                        System.out.println("NOT of " + Integer.toBinaryString(x) + " is "
                                + Integer.toBinaryString(~x) + " (binary).");
                        break;
                    case N_OR:
                        System.out.print("Enter X = ");
                        x = scanner.nextInt();
                        System.out.print("Enter Y = ");
                        y = scanner.nextInt();

                        //N-AND is done by combining bitwise AND(&) and NOT(~) bitwise operator.
                        System.out.println(x + " N-AND " + y + " is " + ~(x & y) + " (decimal).");
                        System.out.println(Integer.toBinaryString(x) + " N-AND " + Integer.toBinaryString(y)
                                + " is " + Integer.toBinaryString(~(x & y)) + " (binary).");
                        break;
                    case N_AND:
                        System.out.print("Enter X = ");
                        x = scanner.nextInt();
                        System.out.print("Enter Y = ");
                        y = scanner.nextInt();

                        //N-OR is done by combining bitwise OR(|) and NOT(~) bitwise operator.
                        System.out.println(x + " N-OR " + y + " is " + ~(x | y) + " (decimal).");
                        System.out.println(Integer.toBinaryString(x) + " N-OR " + Integer.toBinaryString(y)
                                + " is " + Integer.toBinaryString(~(x | y)) + " (binary).");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (InputMismatchException exception) {        //Indicates that the token retrieved does not match
            System.out.println(exception.getMessage());     //the pattern for the expected type, or that the
            System.out.println("Restarting...");            //token is out of range for the expected type.

            //Will call main() method recursively if 'InputMismatchException' is caught.
            main(args);
        }
    }

    //Menu for matching the switch case in main().
    public static void printMenu() {
        System.out.println("Press\n" +
                "  0 - Exit application\n" +
                "  1 - Re-print menu\n" +
                "  2 - AND between two inputs\n" +
                "  3 - OR between two inputs\n" +
                "  4 - NOT between two inputs\n" +
                "  5 - N-AND between two inputs\n" +
                "  6 - N-OR between two inputs\n");
    }
}
