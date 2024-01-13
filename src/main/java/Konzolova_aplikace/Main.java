package Konzolova_aplikace;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EvidencePojisteni evidence = new EvidencePojisteni();
        Scanner scanner = new Scanner(System.in);

        String jmeno;
        String prijmeni;
        int vek = 0;
        String telefon;

        while (true) {
            System.out.println("1. Vytvořit pojištěného");
            System.out.println("2. Zobrazit seznam pojištěných");
            System.out.println("3. Vyhledat pojištěného");
            System.out.println("4. Konec");

            System.out.print("Vyberte akci (1-4): ");
            int volba = scanner.nextInt();
            scanner.nextLine(); // Pro přečtení zbývajícího znaku nového řádku

            switch (volba) {
                case 1:
                    System.out.print("Zadejte jméno: ");
                    jmeno = scanner.nextLine();

                    // Validace prázdného příjmení
                    if (jmeno.isEmpty()) {
                        System.out.println("Chyba: Jméno nesmí být prázdné.");
                        break;
                    }

                    System.out.print("Zadejte příjmení: ");
                    prijmeni = scanner.nextLine();

                    // Validace na neplatné znaky v příjmení
                    if (!prijmeni.matches("[a-zA-Zá-žÁ-Ž]+")) {
                        System.out.println("Chyba: Příjmení obsahuje neplatné znaky.");
                        break;
                    }

                    System.out.print("Zadejte věk: ");

                    try {
                        vek = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Chyba: Věk musí být celé číslo");
                        break;
                    }

                    System.out.print("Zadejte telefon: ");

                    telefon = scanner.next();

                    evidence.vytvorPojisteneho(jmeno, prijmeni, vek, telefon);
                    break;
                case 2:
                    evidence.zobrazSeznamPojistenych();
                    break;
                case 3:
                    System.out.print("Zadejte jméno: ");
                    jmeno = scanner.nextLine();

                    // Validace prázdného příjmení
                    if (jmeno.isEmpty()) {
                        System.out.println("Chyba: Jméno nesmí být prázdné.");
                        break;
                    }

                    System.out.print("Zadejte příjmení: ");
                    prijmeni = scanner.nextLine();

                    // Validace na neplatné znaky v příjmení
                    if (!prijmeni.matches("[a-zA-Zá-žÁ-Ž]+")) {
                        System.out.println("Chyba: Příjmení obsahuje neplatné znaky.");
                        break;
                    }

                    evidence.vyhledejPojisteneho(jmeno, prijmeni);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Chyba: Neplatná volba.");
                    break;
            }
        }
    }
}

