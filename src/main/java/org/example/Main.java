package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CityCollection cityCollection = new CityCollection();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Dodaj miasto");
            System.out.println("2. Usun miasto");
            System.out.println("3. Porownaj miasta");
            System.out.println("4. Wyswietl miasta");
            System.out.println("5. Wyswietl miasta z wojewodztw");
            System.out.println("6. Wyjdz");
            System.out.print("Wybierz opcję: ");

            int num;
            try {
                num = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Nieprawidłowa opcja, spróbuj ponownie.");
                scanner.nextLine();
                continue;
            }

            switch (num) {
                case 1:
                    cityCollection.addCity();
                    break;
                case 2:
                    cityCollection.removeCity();
                    break;
                case 3:
                    cityCollection.compareCities();
                    break;
                case 4:
                    cityCollection.printCities();
                    break;
                case 5:
                    cityCollection.printCitiesAdminName();
                    System.exit(0);
                    break;
                case 6:
                    System.out.println("Wyjście...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
            }
        }
    }
}
