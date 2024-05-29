package com.example.bookmyshow2.model;

import com.example.bookmyshow2.model.constant.PaymentMode;
import com.example.bookmyshow2.model.constant.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private LocalDateTime paymentTime;
    private double amount;
    private String referenceId;
    @ManyToOne
    private Ticket ticket;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
}
