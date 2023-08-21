import java.util.Scanner;
public class Taschenrechner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gebe deine beiden Wunschzahlen nun ein");
        System.out.println("(Vergessen nicht, diese durch ein Leerzeichen zu trennen!)");
        System.out.print("=> ");

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

        double ergebnis;

        switch (dieZahlen) {
            case 1 -> ergebnis = zahl1 + zahl2;
            case 2 -> ergebnis = zahl1 - zahl2;
            case 3 -> ergebnis = zahl1 * zahl2;
            case 4 -> {
                if (zahl2 != 0) {
                    ergebnis = zahl1 / zahl2;
                } else {
                    System.out.println("Durch 0 dividieren nicht möglich. Probiere bitte eine andere Zahl.");
                    return;
                }
            }
            default -> {
                System.out.println("Ungültige Rechen-Operation.");
                return;
            }
        }

        System.out.println("Dein Ergebnis: " + ergebnis);

        scanner.close();
    }
}