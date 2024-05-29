package com.example.bookmyshow2.repository;

import com.example.bookmyshow2.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    Seat findSeatBySeatNumber(String seatNumber);
}
