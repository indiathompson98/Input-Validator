
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneBook {
    private static ArrayList<Person> contactList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("Hi, This is a contact management program\uD83D\uDCF2");
        System.out.println("=========================================");

        while (true){
            System.out.println("Choose what you'll like to do from below: ");
            System.out.println("1. Add a new contact.\n2. Delete a contact by name.\n3. Delete a contact by number.\n4. List all contacts.\n0. End program.");

            int userChoice = input.nextInt();

            switch (userChoice){
                case 1: AddContact();
                    break;
                case 2: deleteContactByName();
                    break;
                case 3: deleteContactByNumber();
                    break;
                case 4: listContact();
                    break;
                case 0:
                    System.out.println("Thanks for testing\uD83E\uDD13!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Enter \"0\" to terminate");
            }
        }



    }


    public static void AddContact(){
        input.nextLine();
        String nameRegex = "(^[A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})([ ])([A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})([ ])([A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})|"+
                            "(^[A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})([ ])([A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})|"+
                            "(^[A-Za-z'’]{1,35})|"+
                            "(^[A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})([,])([ ])([A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})|"+
                            "(^[A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})([,])([ ])([A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})([ ])([A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})|"+
                            "(^[A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})([,])([ ])([A-Za-z'’]{1,35}\\-{0,1}[A-Za-z]{1,35})([ ])([A-Za-z])\\.$";

        String phoneRegex = "(^[\\d]{5}$)|" +
                            "(^\\([\\d]{3}\\)[\\d]{3}\\-[\\d]{4}$)|" +
                            "(^[\\d]{3}\\-[\\d]{4}$)|" +
                            "(^\\+[\\d]\\([\\d]{3}\\)[\\d]{3}\\-[\\d]{4}$)|" +
                            "(^\\+[\\d]{2}\\ \\([\\d]{2}\\)\\ [\\d]{3}\\-[\\d]{4}$)|" +
                            "(^[\\d]{3}\\ [\\d]{4}$)|(^[\\d]\\([\\d]{3}\\)[\\d]{3}\\-[\\d]{4}$)|" +
                            "(^[\\d]{3}[ ][\\d]{3}[ ][\\d]{3}[ ][\\d]{4}$)|" +
                            "(^[\\d]{5}\\.[\\d]{5}$)|" +
                            "(^[\\d]{3}[ ][\\d][ ][\\d]{3}[ ][\\d]{3}[ ][\\d]{4}$)|" +
			                "(^[\\d]{10}$)";

        System.out.println("Please Enter contact details");

        while(true){


            System.out.print("Contact name: ");
            String usernameInput =input.nextLine().trim();

            System.out.print("Contact telephone number: ");
            String numberInput =input.nextLine().trim();

            if (Pattern.matches(nameRegex, usernameInput) && Pattern.matches(phoneRegex, numberInput)) {
                contactList.add(new Person(usernameInput, numberInput));
                System.out.println("✅Contact successfully added✅\n");
                break;
            }
            System.out.println("❌Invalid username or Invalid number.Try again!❌");


        }
    }

    public static void deleteContactByName(){
        input.nextLine();
        System.out.print("\nEnter the name of the contact you want to delete:");
        String contactName = input.nextLine().trim();
        boolean found = false;

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getNames().contains(contactName)) {
                contactList.remove(i);
                found = true;
                System.out.println(contactName + " was successfully deleted\uD83D\uDEAE\n");
                break;
            }
        }
        if (!found) {
            System.out.println("❌No contact by the name: " + contactName+"❌\n");
        }
    }

    public static void deleteContactByNumber(){
        input.nextLine();
        System.out.print("\nEnter the exact number of the contact you want to delete:");
        String contactNumber = input.nextLine().trim();

        boolean found = false;

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getPhoneNumber().equals(contactNumber)) {
                contactList.remove(i);
                found = true;
                System.out.println(contactNumber + " was successfully deleted\uD83D\uDEAE\n");
                break;
            }
        }
        if (!found) {
            System.out.println("❌No contact by the name: " + contactNumber + "❌\n");
        }
    }

    public static void listContact(){
        System.out.println("Below are all the contact in your phonebook: ");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(i+1 + ". Name:" + contactList.get(i).getNames() +
                                ", Number: " + contactList.get(i).getPhoneNumber());
        }
        System.out.println("");
    }



}
