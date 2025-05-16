import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private final Map<String, SubMenu> subMenus = new HashMap<>();

    public MenuHandler() {
        subMenus.put("1", new SubMenu("ACHETER CREDIT OU OFFRE YAS",
                List.of(
                        "1. Crédit pour mon numéro",
                        "2. Crédit pour autre numéro",
                        "3. Offre pour mon numéro",
                        "4. Offre pour autre numéro"
                ),
                List.of("1", "2", "3", "4")
        ));

        subMenus.put("2", new SubMenu("TRANSFERER ARGENT",
                List.of(
                        "0. Sans numéro",
                        "5. MVola Épargne",
                        "6. Rembourser une avance",
                        "9. Répertoire MVola"
                ),
                List.of("0", "5", "6", "9")
        ));

        subMenus.put("3", new SubMenu("MVOLA CREDIT OU EPARGNE",
                List.of(
                        "1. MVola Épargne",
                        "2. MVola Crédit"
                ),
                List.of("1", "2")
        ));

        subMenus.put("4", new SubMenu("RETRAIT ARGENT",
                List.of(
                        "1. Auprès d'un Agent Mvola",
                        "2. Auprès d'un DAB SGM"
                ),
                List.of("1", "2")
        ));

        subMenus.put("5", new SubMenu("PAIEMENT FACTURES & PARTENAIRES",
                List.of(
                        "1. Accepter une demande d'argent",
                        "2. YAS ou MOOV",
                        "3. Electricite et eau",
                        "4. Assurances"
                ),
                List.of("1", "2", "3", "4")
        ));

        subMenus.put("6", new SubMenu("MON COMPTE",
                List.of(
                        "1. Consultation du solde",
                        "2. Consulter mes 3 dernieres transactions",
                        "3. Reçu par e-mail",
                        "4. Mon adresse e-mail",
                        "5. Mon repertoire MVola"
                ),
                List.of("1", "2", "3", "4", "5")
        ));

        subMenus.put("7", new SubMenu("RECEVOIR DE L'ARGENT",
                List.of(
                        "1. MVola Épargne",
                        "2. MVola Avance",
                        "3. Western Union"
                ),
                List.of("1", "2", "3")
        ));

        subMenus.put("8", new SubMenu("BANQUES ET MICRO-FINANCES",
                List.of(
                        "1. Ma Banque",
                        "2. Mon Institution de Micro-Finances"
                ),
                List.of("1", "2")
        ));
    }

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

    private void printMenu(final int page) {
        System.out.println("------ MVOLA ------");
        List<String> menu = (page == 1) ? menuPage1 : menuPage2;
        for (String item : menu) {
            System.out.println(item);
        }
        System.out.println("0. Quitter");
    }

    private void handleInput(final String input) {
        if (subMenus.containsKey(input)) {
            subMenus.get(input).display(this);
            running = false;
            return;
        }

        switch (input) {
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

    public void restart() {
        this.running = true;
        this.start();
    }
}
