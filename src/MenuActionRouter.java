public class MenuActionRouter {

    public static void handleOption(String input) {
        switch (input) {
            case "1":
                System.out.println(" Acheter Crédit ou Offre YAS");
                break;
            case "2":
                System.out.println("Transférer Argent");
                break;
            case "3":
                System.out.println("MVola Crédit ou Épargne");
                break;
            case "4":
                System.out.println("Retrait d'argent");
                break;
            case "5":
                System.out.println(" Paiement Factures & Partenaires");
                break;
            case "6":
                System.out.println("Mon compte");
                break;
            case "7":
                System.out.println("Recevoir de l'Argent");
                break;
            case "8":
                System.out.println("Banques et Micro-Finances");
                break;
            default:
                System.out.println("Erreur inattendue.");
        }
    }
}
