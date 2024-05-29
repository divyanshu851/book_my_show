package com.example.bookmyshow2.dto;

import com.example.bookmyshow2.model.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Integer> showSeatIds;
    private Integer userId;
}
