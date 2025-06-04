package com.greenkart.pickup_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("pickup_slots")
public class PickupSlot {
    @Id
    private Long id;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean available;
}
