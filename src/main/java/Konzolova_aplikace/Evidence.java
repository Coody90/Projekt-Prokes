package Konzolova_aplikace;


import java.util.ArrayList;
import java.util.List;

class EvidencePojisteni {
    private List<Pojisteny> pojisteniList;

    public EvidencePojisteni() {
        this.pojisteniList = new ArrayList<>();
    }

    public void vytvorPojisteneho(String jmeno, String prijmeni, int vek, String telefon) {
        // Validace prázdného jména
        if (jmeno.isEmpty()) {
            System.out.println("Chyba: Jméno nesmí být prázdné.");
            return;
        }

        // Validace na neplatné znaky v jméně
        if (!jmeno.matches("[a-zA-Zá-žÁ-Ž]+")) {
            System.out.println("Chyba: Jméno obsahuje neplatné znaky.");
            return;
        }

        // Validace prázdného příjmení
        if (prijmeni.isEmpty()) {
            System.out.println("Chyba: Příjmení nesmí být prázdné.");
            return;
        }

        // Validace na neplatné znaky v příjmení
        if (!prijmeni.matches("[a-zA-Zá-žÁ-Ž]+")) {
            System.out.println("Chyba: Příjmení obsahuje neplatné znaky.");
            return;
        }

        int vekMin = 0;
        int vekMax = 150;

        // Validace věku
        if (vek < vekMin || vek > vekMax) {
            System.out.println("Chyba: Věk musí být v rozmezí " + vekMin + " až " + vekMax + ".");
            return;
        }

        // Validace prázdného telefonního čísla
        if (telefon.isEmpty()) {
            System.out.println("Chyba: Telefonní číslo nesmí být prázdné.");
            return;
        }

        // Validace neplatných znaků v telefonním čísle
        if (!telefon.matches("\\d+")) {
            System.out.println("Chyba: Telefonní číslo může obsahovat pouze číslice.");
            return;
        }

        // Další validace a inicializace Pojisteneho
        // ...

        Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni, vek, telefon);
        pojisteniList.add(pojisteny);
        System.out.println("Pojistěný byl úspěšně vytvořen.");
    }

    public void zobrazSeznamPojistenych() {
        if (pojisteniList.isEmpty()) {
            System.out.println("Seznam pojištěných je prázdný.");
        } else {
            System.out.println("Seznam pojištěných:");
            for (Pojisteny pojisteny : pojisteniList) {
                System.out.println(pojisteny);
            }
        }
    }

    public void vyhledejPojisteneho(String jmeno, String prijmeni) {
        for (Pojisteny pojisteny : pojisteniList) {
            if (pojisteny.getJmeno().equalsIgnoreCase(jmeno) && pojisteny.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                System.out.println("Nalezený pojištěný: " + pojisteny);
                return;
            }
        }
        System.out.println("Pojištěný nebyl nalezen.");
    }
}
