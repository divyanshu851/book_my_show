package com.example.bookmyshow2.service;

import com.example.bookmyshow2.model.City;
import com.example.bookmyshow2.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City saveCity(String cityName){
        City city = new City();
        city.setName(cityName);
        return cityRepository.save(city);
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }
    public City getCity(int cityId){
        return cityRepository.findById(cityId).get();
    }

    public City findCityByName(String cityName){
        return cityRepository.getCityByName(cityName);
    }

    public boolean deleteCity(int cityId){
        cityRepository.deleteById(cityId);
        return true;
    }

}
