import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    void main() {
            int running = 0;
            while (running != 5){
                clearScreen();
                showMenu();
                running = navigateMenu();

                switch (running) {
                    case 1 -> {}
                    case 2 -> {}
                    case 3 -> {}
                    case 4 -> {}
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
        IO.println("=========== Kontaktbok ===========");
        IO.println("| 1. Visa kontakter              |");
        IO.println("| 2. Lägg till ny kontakt        |");
        IO.println("| 3. Redigera befintlig kontakt  |");
        IO.println("| 4. Ta bort befintlig kontakt   |");
        IO.println("| 5. Avsluta programmet          |");
        IO.println("==================================");
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
