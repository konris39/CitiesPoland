package org.example;

public interface usefull {
    default String compareCitiesPopulation(String cityName1, String cityName2, CityCollection cityCollection) {

        City city1 = cityCollection.findByName(cityName1);
        City city2 = cityCollection.findByName(cityName2);

        if (city1 == null || city2 == null) {
            return "Nie znaleziono obu miast. Upewnij się, że podałeś poprawne nazwy miast.";
        }
        int result = city1.getPopulation() - city2.getPopulation();
        if (result > 0) {
            return city1.getName() + " ma większą populację niż " + city2.getName() + " o: " + Math.abs(result);
        } else if (result < 0) {
            return city2.getName() + " ma większą populację niż " + city1.getName() + " o: " + Math.abs(result);
        } else {
            return city1.getName() + " i " + city2.getName() + " mają tę samą populację.";
        }
    }
}
