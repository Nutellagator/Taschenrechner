import java.util.Scanner;

public class Taschenrechner2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean weiter = true;
        do {
            System.out.println("Gebe deine beiden Wunschzahlen nun ein");
            System.out.println("(Vergessen nicht, diese durch ein Leerzeichen zu trennen!)");
            System.out.println("Wenn du aufhören möchtest, schreibe (exit) ");
            System.out.print("=> ");

            if (scanner.hasNextDouble()) {

                // es wird mit nextDouble die nächste Fließkommazahl in der entsprechenden Variable gespeichert
                double zahl1 = scanner.nextDouble();
                double zahl2 = scanner.nextDouble();

                System.out.println("Welche Rechen-Operation ?:");
                System.out.print("1 - addieren");
                System.out.print(" | 2 - subtrahieren");
                System.out.print(" | 3 - multiplizieren");
                System.out.println(" | 4 - dividieren");
                System.out.print("=> ");

                //Datentyp double ist für diese Variable nicht möglich, da switch-case kein double parameter akzeptiert
                int dieZahlen = scanner.nextInt();
                double ergebnis = 0;

                //enhanced Switch
                //benötigt im Gegensatz zum Switch case kein -break und Anweisung selber kann Wert zurückgeben
                switch (dieZahlen) {
                    case 1 -> ergebnis = zahl1 + zahl2;
                    case 2 -> ergebnis = zahl1 - zahl2;
                    case 3 -> ergebnis = zahl1 * zahl2;
                    case 4 -> {
                        if (zahl2 != 0) {
                            ergebnis = zahl1 / zahl2;
                        } else {
                            System.out.println("Durch 0 dividieren nicht möglich. Probiere bitte eine andere Zahl.");
                            continue;
                        }
                    }
                    default -> {
                        System.out.println("Ungültige Rechen-Operation.");
                        continue;
                    }
                }
                System.out.println("-----------------");
                System.out.println("Ergebnis = " + ergebnis);
                System.out.println("-----------------");

            } else if (scanner.hasNext("exit")) {
                weiter = false;
                System.out.println("Bis zum nächsten Mal! ;).");
            } else {
                System.out.println("Ungültige Eingabe.");
                System.out.println("Zulässig sind nur Dezimalzahlen!");
                System.out.println("Probiere es bitte erneut.");
                //diese Methode liest die eingegebene Zeichenkette bis zum nächsten Leerzeichen oder Zeilenumbruch aus
                scanner.next(); // Verarbeitet ungültige Eingabe, um Endlosschleife zu vermeiden
            }

        } while (weiter);

        scanner.close();
    }
}
