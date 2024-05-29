package com.example.bookmyshow2.repository;

import com.example.bookmyshow2.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    City getCityByName(String name);
}
