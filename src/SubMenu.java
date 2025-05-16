import java.util.List;
import java.util.Scanner;

public class SubMenu {
    private final String title;
    private final List<String> options;
    private final List<String> validChoices;

    public SubMenu(final String title, final List<String> options, final List<String> validChoices) {
        this.title = title;
        this.options = options;
        this.validChoices = validChoices;
    }

    public void display(final MenuHandler menuHandler) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- " + title + " ----");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("**. Menu principal");
        System.out.print("Choix : ");

        String input = scanner.nextLine().trim();
        System.out.println();

        if (input.equals("**")) {
            menuHandler.restart();
        } else if (validChoices.contains(input)) {
            options.stream()
                    .filter(opt -> opt.startsWith(input + "."))
                    .findFirst()
                    .ifPresent(opt -> {
                        String label = opt.substring(opt.indexOf(".") + 2); // sauter le numéro et le point + espace
                        System.out.println(label);
                    });
            System.out.println("Fin de la session.");
        } else {
            System.out.println("Option invalide. Fin de la session.");
        }
    }
}
