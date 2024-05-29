package com.example.bookmyshow2.service;

import com.example.bookmyshow2.model.Auditorium;
import com.example.bookmyshow2.model.City;
import com.example.bookmyshow2.model.Seat;
import com.example.bookmyshow2.model.Theatre;
import com.example.bookmyshow2.model.constant.AuditoriumFeature;
import com.example.bookmyshow2.model.constant.SeatStatus;
import com.example.bookmyshow2.model.constant.SeatType;
import com.example.bookmyshow2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;

    public boolean initialise(){
        City damoh = new City("Damoh");
        City gwalior = new City("Gwalior");
        City sagar = new City("Sagar");
        City khurai = new City("Khurai");
        City bina = new City("Bina");
        City bhopal = new City("Bhopal");
        cityRepository.save(damoh);
        cityRepository.save(gwalior);
        cityRepository.save(sagar);
        cityRepository.save(khurai);
        cityRepository.save(bina);
        cityRepository.save(bhopal);

        City saved_sagar = cityRepository.getCityByName("Sagar");
        Theatre platinum_plaza = new Theatre("PlatinumPlaza", "In Paradise hotal");
        Theatre cineCity = new Theatre("CinyCitytheatre", "near DMA");
        Theatre upsara = new Theatre("Upsara", "In katra bazar");

        theatreRepository.save(platinum_plaza);
        theatreRepository.save(cineCity);
        theatreRepository.save(upsara);

        Theatre saved_platinum_plaza = theatreRepository.findTheatreByName("PlatinumPlaza");
        Theatre saved_cineCity = theatreRepository.findTheatreByName("CinyCitytheatre");
        Theatre saved_upsara = theatreRepository.findTheatreByName("Upsara");
        List<Theatre> sagarTheatres = saved_sagar.getTheatres();
        sagarTheatres.add(saved_platinum_plaza);
        sagarTheatres.add(saved_cineCity);
        sagarTheatres.add(saved_upsara);

        cityRepository.save(saved_sagar);
        Auditorium auditorium = new Auditorium();
        auditorium.setName("Audi 01");
        auditorium.setCapacity(5);
        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.DOLBY, AuditoriumFeature.IMAX));
        auditoriumRepository.save(auditorium);

        for(int i=1; i<=5; i++){
            Seat s = new Seat(i, i, i+" "+i,  SeatType.GOLD, SeatStatus.AVAILABLE);
            seatRepository.save(s);
            seatRepository.findSeatBySeatNumber(i+" "+i);
        }
        return true;
    }
}
