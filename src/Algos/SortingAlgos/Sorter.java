package Algos.SortingAlgos;
import java.util.*;

/**
 * Created by abdul on 7/30/20.
 */

public class Sorter implements ICountrySorter {
    List<Country> result;

    public List<Country> sortCountries(List<Country> availableCountries, List<Country> specialCountries) {
        result = new ArrayList<>();
        TreeSet set = new TreeSet<Country>(new Comparator<Country>(){
            @Override
            public int compare(Country c1, Country c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });

        set.addAll(availableCountries);

        for(Country c: specialCountries){
            if(set.contains(c)){
                result.add(c);
                set.remove(c);
            }
        }
        result.addAll(set);
        return result;

    }

    public static void main(String[] args){
        List<Country> availableCountries = new ArrayList<>();
        List<Country> specialCountries = new ArrayList<>();

        Country c1 = new Country("mexico");
        Country c2  = new Country ("US");
        Country c3 = new Country ("Canada");
        Country c4 = new Country("japan");
        Country c5 = new Country("Russia");
        Country c6 = new Country ("China");
        Country c7 = new Country("pakistan");
        Country c8 = new Country("bhutan");
        Country c9 = new Country("brazil");
        Country c10 = new Country("UK");

        Country c11 = new Country("Australia");
        Country c12 = new Country("France");

        availableCountries.add(c1);
        availableCountries.add(c2);
        availableCountries.add(c3);
        availableCountries.add(c4);
        availableCountries.add(c5);
        availableCountries.add(c6);
        availableCountries.add(c7);
        availableCountries.add(c8);
        availableCountries.add(c9);
        availableCountries.add(c10);


        specialCountries.add(c2);
        specialCountries.add(c4);
        specialCountries.add(c5);
        specialCountries.add(c9);
        specialCountries.add(c11);
        specialCountries.add(c12);


        Sorter s = new Sorter();
        List<Country> result = s.sortCountries(availableCountries,specialCountries);
        for(Country c: result){
            System.out.println(c.getName());
        }
    }
}



class Country {
    private String name;

    public Country(String name) {
        this.name = name.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

interface ICountrySorter {
    public List<Country> sortCountries(List<Country> availableCountries, List<Country> specialCountries);
}