package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount() {
        return cities.size();
    }

    public void addCity(City city) {
        cities.add(city);
        return;
    }

    /**
     * This checks if a city is in the cityList
     * @param city
     *      This is a city to compare with the other cities
     * @return
     *      Return true if city is in cityList, otherwise return false
     */
    public boolean hasCity(City city) {
        for (City city2 : cities) {
            if (city2.compareTo(city) == 0 && city2.getProvinceName() == city.getProvinceName()) {
                return true;
            }
        }
        return false;
    }

    public void deleteCity(City city) {
        if (hasCity(city)) {
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).compareTo(city) == 0 && cities.get(i).getProvinceName() == city.getProvinceName()) {
                    cities.remove(i);
                }
            }
        }
    }

    public int countCities() {
        int count = 0;
        for (City city: cities) {
            count++;
        }
        return count;
    }
}
