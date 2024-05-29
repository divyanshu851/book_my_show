package com.example.bookmyshow2.sevice;

import com.example.bookmyshow2.model.ShowSeat;
import com.example.bookmyshow2.model.Ticket;
import com.example.bookmyshow2.model.constant.ShowSeatStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Getter
@Setter
@Service
public class TicketService {

    @Autowired
    private ShowSeatService showSeatService;
    @Transactional(isolation= Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception {
        for(int showSeatId : showSeatIds){
            ShowSeat seat =  showSeatService.getShowSeat(showSeatId);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new Exception("Seat is not available anymore");
            }
        }

        for(int showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(seat);
        }
        startPayment(showSeatIds);
        return new Ticket();
    }

    public boolean startPayment(List<Integer> showSeatId){
        return true;
    }

    public String greet(){
        return "Hello world";
    }
}
