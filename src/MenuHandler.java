import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;
    private int currentPage = 1;

    private final List<String> menuPage1 = List.of(
            "1. Acheter Crédit ou Offre YAS",
            "2. Transférer Argent (vers toute destination)",
            "3. MVola Crédit ou Épargne",
            "4. Retrait d'argent",
            "#. Page suivante"
    );

    private final List<String> menuPage2 = List.of(
            "5. Paiement Factures & Partenaires",
            "6. Mon compte",
            "7. Recevoir de l'Argent",
            "8. Banques et Micro-Finances",
            "*. Page précédente"
    );

    public void start() {
        while (running) {
            printMenu(currentPage);
            System.out.print("Choix : ");
            String input = scanner.nextLine().trim();
            System.out.println();
            handleInput(input);
        }
        scanner.close();
    }

    private void printMenu(int page) {
        System.out.println("------ MVOLA ------");
        List<String> menu = (page == 1) ? menuPage1 : menuPage2;
        for (String item : menu) {
            System.out.println(item);
        }
        System.out.println("0. Quitter");
    }

    private void handleInput(String input) {
        switch (input) {
            case "1", "2", "3", "4", "5", "6", "7", "8":
                MenuActionRouter.handleOption(input);
                running = false;
                break;
            case "#":
                currentPage = 2;
                break;
            case "*":
                currentPage = 1;
                break;
            case "0":
                System.out.println("Fin de la session.");
                running = false;
                break;
            default:
                System.out.println("Option invalide. Réessayez.");
        }
    }
}
