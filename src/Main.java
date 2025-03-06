import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HistoryManager historyManager = new HistoryManager();

        while (true) {
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Odwiedź stronę");
            System.out.println("2. Cofnij się");
            System.out.println("3. Pokaż historię");
            System.out.println("4. Zakończ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Podaj URL strony: ");
                    String url = scanner.nextLine();
                    System.out.print("Podaj tytuł strony: ");
                    String title = scanner.nextLine();
                    historyManager.visitPage(url, title);
                    System.out.println("Strona odwiedzona: " + title);
                    break;
                case 2:
                    historyManager.goBack();
                    System.out.println("Cofnięto się do poprzedniej strony.");
                    break;
                case 3:
                    List<Map.Entry<String, String>> history = historyManager.getHistory();
                    if (history.isEmpty()) {
                        System.out.println("Brak historii.");
                    } else {
                        System.out.println("Historia odwiedzonych stron:");
                        for (Map.Entry<String, String> entry : history) {
                            System.out.println("URL: " + entry.getKey() + " | Tytuł: " + entry.getValue());
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Niepoprawna opcja, spróbuj ponownie.");
            }
        }
    }
}




class HistoryManager {
    private Stack<Map.Entry<String, String>> history = new Stack<>();

    public void visitPage(String url, String title) {
        history.push(new AbstractMap.SimpleEntry<>(url, title));
    }

    // Metoda do cofania się do poprzedniej strony
    public void goBack() {
        if (!history.isEmpty()) {
            history.pop();
        } else {
            System.out.println("Brak stron w historii!");
        }
    }

    public List<Map.Entry<String, String>> getHistory() {
        return new ArrayList<>(history);
    }

}

