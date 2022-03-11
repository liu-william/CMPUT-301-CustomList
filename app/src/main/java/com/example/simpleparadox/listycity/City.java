package com.example.simpleparadox.listycity;

public class City {
    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     * Returns string compared lexicographically
     * @param city
     *      A city instance that is being compared to current city.
     * @return
     *      0 -- if strings are lexicographically equal (i.e. this.city's name == city's name)
     *      int greater than 0 -- if this.city's name is longer than city's name
     *      int less than 0 -- if this.city's name is shorter than city's name
     */
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
}
