import java.util.Scanner;

public class Taschenrechner3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Erstellt einen Scanner, um Eingaben zu lesen
        boolean weiter = true; // Eine Flagge, um die Schleife zu steuern

        do {
            System.out.println("Gib deine Zahlen ein, getrennt durch Leerzeichen:");
            System.out.println("(Um zu beenden, schreibe 'exit')");
            System.out.print("=> ");

            if (scanner.hasNext("exit")) {
                weiter = false; // Beendet die Schleife, wenn "exit" eingegeben wird
                System.out.println("Bis zum nächsten Mal! ;)");
            } else {
                String inputLine = scanner.nextLine(); // Liest die komplette Zeile der Eingabe
                String[] numberStrings = inputLine.split(" "); // Teilt die Eingabe anhand von Leerzeichen

                if (numberStrings.length < 2) {
                    System.out.println("Ungültige Eingabe. Mindestens zwei Zahlen erforderlich.");
                    continue; // Startet die Schleife erneut, um neue Eingabe zu erhalten
                }

                double[] numbers = new double[numberStrings.length];
                boolean validInput = true;

                for (int i = 0; i < numberStrings.length; i++) {
                    try {
                        numbers[i] = Double.parseDouble(numberStrings[i]); // Konvertiert Zeichenfolge in Zahl
                    } catch (NumberFormatException e) {
                        System.out.println("Ungültige Eingabe. Nur Dezimalzahlen erlaubt.");
                        validInput = false;
                        break;
                    }
                }

                if (!validInput) {
                    continue; // Startet die Schleife erneut, um neue Eingabe zu erhalten
                }

                System.out.println("Welche Rechen-Operation?");
                System.out.println("1 - addieren | 2 - subtrahieren | 3 - multiplizieren | 4 - dividieren");
                System.out.print("=> ");

                int operation = scanner.nextInt();
                double result = 0;

                switch (operation) {
                    case 1:
                        result = add(numbers); // Aufruf der Methode "add" für Addition
                        break;
                    case 2:
                        result = subtract(numbers); // Aufruf der Methode "subtract" für Subtraktion
                        break;
                    case 3:
                        result = multiply(numbers); // Aufruf der Methode "multiply" für Multiplikation
                        break;
                    case 4:
                        result = divide(numbers); // Aufruf der Methode "divide" für Division
                        break;
                    default:
                        System.out.println("Ungültige Rechen-Operation.");
                        continue; // Startet die Schleife erneut, um neue Operation zu wählen
                }

                System.out.println("-----------------");
                System.out.println("Ergebnis = " + result);
                System.out.println("-----------------");
            }
        } while (weiter); // Führt die Schleife so lange aus, wie "weiter" true ist

        scanner.close(); // Schließt den Scanner, um Ressourcen freizugeben
    }

    // Die folgenden Methoden führen die jeweilige Rechenoperation aus und geben das Ergebnis zurück

    public static double add(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number; // Summiert alle Zahlen im Array
        }
        return sum; // Gibt die Summe zurück
    }

    public static double subtract(double[] numbers) {
        double result = numbers[0]; // Setzt das Ergebnis auf die erste Zahl
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i]; // Subtrahiert die restlichen Zahlen vom Ergebnis
        }
        return result; // Gibt das Ergebnis der Subtraktion zurück
    }

    public static double multiply(double[] numbers) {
        double product = 1; // Setzt das Produkt auf 1 (neutrales Element der Multiplikation)
        for (double number : numbers) {
            product *= number; // Multipliziert alle Zahlen im Array
        }
        return product; // Gibt das Produkt zurück
    }

    public static double divide(double[] numbers) {
        double result = numbers[0]; // Setzt das Ergebnis auf die erste Zahl
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                result /= numbers[i]; // Dividiert die restlichen Zahlen vom Ergebnis
            } else {
                System.out.println("Durch 0 dividieren nicht möglich.");
                return 0; // Beendet die Methode und gibt 0 zurück, wenn eine Division durch 0 entdeckt wird
            }
        }
        return result; // Gibt das Ergebnis der Division zurück
    }
}