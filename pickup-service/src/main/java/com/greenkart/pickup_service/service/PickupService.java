package com.greenkart.pickup_service.service;

import com.greenkart.pickup_service.model.PickupSlot;
import com.greenkart.pickup_service.repository.PickupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PickupService {
    private final PickupRepository repository;

    public Flux<PickupSlot> getAllSlots() {
        return repository.findAll();
    }

    public Flux<PickupSlot> getSlotsByLocation(String location) {
        return repository.findByLocation(location);
    }

    public Mono<PickupSlot> addSlot(PickupSlot slot) {
        return repository.save(slot);
    }

    public Mono<Void> deleteSlot(Long id) {
        return repository.deleteById(id);
    }
}
