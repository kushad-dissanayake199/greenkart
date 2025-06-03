package com.greenkart.pickup_service.controller;

import com.greenkart.pickup_service.model.PickupSlot;
import com.greenkart.pickup_service.service.PickupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/pickup")
@RequiredArgsConstructor
public class PickupController {
    private final PickupService service;

    @GetMapping
    public Flux<PickupSlot> getAllSlots() {
        return service.getAllSlots();
    }

    @GetMapping("/location/{location}")
    public Flux<PickupSlot> getByLocation(@PathVariable String location) {
        return service.getSlotsByLocation(location);
    }

    @PostMapping
    public Mono<PickupSlot> addSlot(@RequestBody PickupSlot slot) {
        return service.addSlot(slot);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteSlot(@PathVariable Long id) {
        return service.deleteSlot(id);
    }
}
