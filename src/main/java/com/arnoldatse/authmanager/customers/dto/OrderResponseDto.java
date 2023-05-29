package com.arnoldatse.authmanager.customers.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class OrderResponseDto {
    private String id;
    private LocalDateTime date;
    private int amount;

    public OrderResponseDto(String id, LocalDateTime date, int amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "OrderResponseDto{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
