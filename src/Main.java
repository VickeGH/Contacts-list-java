import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();

    void main() {
            boolean running = true;
            while (running) {
                clearScreen();
                showMenu();
                int choice = navigateMenu();

                switch (choice) {
                    case 1 -> {
                        showContacts();
                        askContinue();
                    }
                    case 2 -> addContact();
                    case 3 -> editContact();
                    case 4 -> removeContact();
                    case 5 -> {
                        IO.println("Nu avslutas programmet. Hejdå!");
                        running = false;
                    }
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
        IO.println();
    }

    void clearScreen() {
        IO.println();
        IO.print("\u001B[H\u001B[2J");
        IO.println();
    }

    void askContinue() {
        IO.println();
        IO.print("Tryck Enter för att fortsätta...");
        scanner.nextLine();
        IO.println();
    }

    void showContacts() {
        clearScreen();
      //IO.println("=========== Kontaktboken ===========");
        IO.println("============= Kontakter ============");
        IO.println(" index: Namn, Telefonnummer, Email  ");
        IO.println("====================================");
        if (contacts.isEmpty()) {
            IO.println("Det finns inga kontakter.");
        } else {
            int i = 1;
            for (Contact contact : contacts) {
                IO.println(i + ". " + contact.getName() + ", " + contact.getPhone() + ", " + contact.getEmail());
                i++;
            }
        }
        IO.println();
    }

    void addContact() {
        clearScreen();
      //IO.println("=========== Kontaktboken ===========");
        IO.println("======= Lägg till ny kontakt =======");
        IO.println();
        IO.print("Namn: ");
        String name = scanner.nextLine();
        IO.print("Tel: ");
        String phone = scanner.nextLine();
        IO.print("Email: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, phone, email));
        IO.println();
        IO.println("Kontakten är tillagd.");
        askContinue();
    }

    void removeContact() {
        boolean running = true;
        while (running) {
            showContacts();

            IO.println("Ange kontaktens index för att ta bort den, eller 0 för att gå tillbaka: ");
            IO.print("Val: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index == 0) {
                running = false;
            } else if (index <= contacts.size() && index >= 1) {
                showContacts();

                index--;
                IO.println("Kontakten för " + contacts.get(index).getName() + " kommer tas bort.");
                IO.println("1. Godkänn, 0. Avbryt");
                IO.print("Val: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
//                if (choice == 1) {
//                    contacts.remove(index);
//                    IO.println("Kontakten är borttagen.");
//                } else if (choice == 2) {
//                    IO.println("Borttagning avbruten.");
//                } else {
//                    IO.println("Okänd kod. Borttagning avbruten.");
//                }
                switch (choice) {
                    case 0 -> IO.println("Borttagning avbruten.");
                    case 1 -> {
                        contacts.remove(index);
                        IO.println("Kontakten är borttagen.");
                    }
                    default -> IO.println("Okänd kod. Borttagning avbruten.");
                }
                askContinue();
            } else {
                IO.println("Det finns ingen kontakt på plats " + index + ". Försök igen.");
                askContinue();
            }

        }
    }
    void editContact() {
        boolean running = true;
        while (running) {
            showContacts();

            IO.println("Ange kontaktens index för att redigera, eller 0 för att gå tillbaka.");
            IO.print("Val: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index == 0) {
                running = false;
            } else if (index <= contacts.size() && index >= 1) {
                showContacts();

                index--;
                IO.println("Vill du redigera; 1. Namn, 2: Telefon, 3: Email? (0: Avbryt)");
                IO.print("Val: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 0 -> {
                        IO.println("Redigering avbruten.");
                        askContinue();
                    }
                    case 1 -> {
                        IO.print("Ange nytt namn: ");
                        contacts.get(index).setName(scanner.nextLine());
                    }
                    case 2 -> {
                        IO.print("Ange nytt nummer: ");
                        contacts.get(index).setPhone(scanner.nextLine());
                    }
                    case 3 -> {
                        IO.print("Ange nytt email: ");
                        contacts.get(index).setEmail(scanner.nextLine());
                    }
                    default -> {
                        IO.println("Okänd kod. Redigering avbruten.");
                        askContinue();
                    }
                }
            } else {
                IO.println("Det finns ingen kontakt på plats " + index + ". Försök igen.");
                askContinue();
            }
        }
    }
}