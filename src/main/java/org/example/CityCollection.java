package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityCollection implements usefull {
    private static final String filePath = "src/main/resources/pl.json";
    ArrayList<City> cities = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public CityCollection() {
        loadCitiesJson();
    }

    public void addCity() {
        System.out.println("Podaj nazwe miasta");
        String cityName = scanner.nextLine();

        System.out.println("Podaj populacje miasta");
        int pop;
        try {
            pop = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Zle dane!");
            return;
        }

        System.out.println("Podaj Wojewodztwo miasta");
        String woj = scanner.nextLine();

        City city = new City(cityName, pop, woj);
        cities.add(city);
    }

    public void removeCity() {
        System.out.println("Podaj nazwe miasta");
        String cityNameDel = scanner.nextLine();

        boolean found = cities.removeIf(city -> city.getName().equalsIgnoreCase(cityNameDel));

        if (found) {
            System.out.println("Usunieto miasto");
        } else {
            System.out.println("Nie ma takiego miasta");
        }
    }

    public String compareCities() {
        System.out.println("Podaj nazwe pierwszego miasta do porownania: ");
        String cityName1 = scanner.nextLine();
        System.out.println("Podaj nazwe drugiego miasta do porownania: ");
        String cityName2 = scanner.nextLine();

        String result = compareCitiesPopulation(cityName1, cityName2, this);
        System.out.println(result);
        return result;
    }

    public void printCities() {
        int count = 0;
        int totalPopulation = 0;
        if (cities.isEmpty()) {
            System.out.println("Brak załadowanych miast.");
        } else {
            for (City city : cities) {
                System.out.println(city);
                count++;
                totalPopulation += city.getPopulation();
            }
            System.out.println("Liczba miast: " + count + ", łączna populacja: " + totalPopulation);
        }
    }

    public void printCitiesAdminName() {
        System.out.println("Podaj nazwe województwa: ");
        String adminName = scanner.nextLine();
        int count = 0;
        int totalPopulation = 0;

        if (adminName == null){
            System.out.println("Brak województwa");
        } else {
            for (City city : cities) {
                if (city.getWojewodztwo().equalsIgnoreCase(adminName)) {
                    System.out.println(city);
                    count++;
                    totalPopulation += city.getPopulation();
                }
            }
            System.out.println("Liczba miast: " + count + ", łączna populacja: " + totalPopulation);
        }
    }

    public City findByName(String cityName) {
        for (City city : cities) {
            if (city.getName().equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        return null;
    }

    public void loadCitiesJson() {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Plik JSON nie istnieje w podanej ścieżce: " + filePath);
            return;
        }

        try {
            List<City> loadedCities = objectMapper.readValue(file, new TypeReference<List<City>>() {});
            cities.addAll(loadedCities);
            System.out.println("Pomyślnie wczytano miasta z pliku JSON.");
        } catch (IOException e) {
            System.out.println("Błąd podczas wczytywania JSON: " + e.getMessage());
        }
    }
}
