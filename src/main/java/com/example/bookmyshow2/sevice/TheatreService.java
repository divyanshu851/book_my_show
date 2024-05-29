package com.example.bookmyshow2.sevice;

import com.example.bookmyshow2.model.City;
import com.example.bookmyshow2.model.Theatre;
import com.example.bookmyshow2.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private CityService cityService;

    public Theatre saveTheatre(String name, String address, int cityId){
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        Theatre saveTheatre = theatreRepository.save(theatre);
        City city = cityService.getCity(cityId);
        List<Theatre> theatres = city.getTheatres();
        theatres.add(theatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);
        return saveTheatre;
    }

    public Theatre getTheatre(int theatreId, int cityId){
        return theatreRepository.findById(theatreId).get();
    }
}
