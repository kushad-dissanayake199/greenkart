package com.greenkart.pickup_service.repository;

import com.greenkart.pickup_service.model.PickupSlot;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PickupRepository extends ReactiveCrudRepository<PickupSlot, Long> {
    Flux<PickupSlot> findByLocation(String location);
}
