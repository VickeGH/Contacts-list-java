import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();

    void main() {
            int running = 0;
            while (running != 5){
                clearScreen();
                showMenu();
                running = navigateMenu();

                switch (running) {
                    case 1 -> {
                        IO.println(contacts);

                        if (contacts.size() < 1) {
                            IO.println("Det finns inga kontakter.");
                        } else {
                            int i = 1;
                            for (Contact contact : contacts) {
                                IO.println(i + ". Namn: " + contact.getName() + " Tel: " + contact.getPhone() + " Email: " + contact.getEmail());
                                i++;
                            }
                        }

                        askContinue();
                    }
                    case 2 -> {
                        IO.print("Namn: ");
                        String name = scanner.nextLine();
                        IO.print("Tel: ");
                        String phone = scanner.nextLine();
                        IO.print("Email: ");
                        String email = scanner.nextLine();

                        contacts.add(new Contact(name, phone, email));
                    }
                    case 3 -> {

                    }
                    case 4 -> {
                        IO.print("Vilken kontakt vill du ta bort? (siffra): ");
                        int index = scanner.nextInt();
                        scanner.nextLine();

                        if (index <= contacts.size() && index >= 1) {
                            index--;
                            IO.println("Kontakten för " + contacts.get(index).getName() + " kommer tas bort.");
                            IO.println("1. Godkänn, 2. Avbryt");
                            IO.print("Val: ");
                            int choice = scanner.nextInt();
                            scanner.nextLine();
                            if (choice == 1) {
                                contacts.remove(index);
                                IO.println("Kontakten är borttagen.");
                            } else if (choice == 2) {
                                IO.println("Borttagning avbruten.");
                            } else {
                                IO.println("Okänd kod. Borttagning avbruten.");
                            }
                        } else {
                            IO.println("Det finns ingen kontakt på plats " + index + ".");
                        }
                        askContinue();

                    }
                    case 5 -> IO.println("Nu avslutas programmet. Hejdå!");
                    default -> {
                        IO.println("Okänd kod. Vänligen försök igen.");
                        askContinue();
                    }
                }
            }
    }

    int navigateMenu() {
        IO.print("Välj kod för att navigera: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        IO.println();
        return choice;
    }

    void showMenu() {
        IO.println("=========== Kontaktboken ===========");
        IO.println("|| 1. Visa kontakter              ||");
        IO.println("|| 2. Lägg till ny kontakt        ||");
        IO.println("|| 3. Redigera befintlig kontakt  ||");
        IO.println("|| 4. Ta bort befintlig kontakt   ||");
        IO.println("|| 5. Avsluta programmet          ||");
        IO.println("====================================");
    }

    void clearScreen() {
        IO.println();
        IO.print("\u001B[H\u001B[2J");
        IO.println();
    }

    void askContinue() {
        IO.println("Tryck Enter för att fortsätta...");
        scanner.nextLine();
    }
}