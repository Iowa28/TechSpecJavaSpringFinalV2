package ru.aminovniaz.techspecjavaspringfinalv2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.aminovniaz.techspecjavaspringfinalv2.dto.SubscriptionDto;
import ru.aminovniaz.techspecjavaspringfinalv2.service.SubscriptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("subscriptions")
    public void createSubscription(@RequestBody @Valid SubscriptionDto subscriptionDto) {
        subscriptionService.createSubscription(subscriptionDto);
    }

    @GetMapping("subscriptions/{id}")
    public SubscriptionDto getSubscription(@PathVariable Long id) {
        return subscriptionService.getSubscription(id);
    }

    @PutMapping("subscriptions/{id}")
    public void updateUser(@RequestBody @Valid SubscriptionDto subscriptionDto, @PathVariable Long id) {
        subscriptionService.updateSubscription(subscriptionDto, id);
    }

    @DeleteMapping("subscriptions/{id}")
    public void deleteUser(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }

    @GetMapping("subscriptions/top")
    public List<SubscriptionDto> getTopSubscriptions() {
        return subscriptionService.getTopSubscriptions();
    }
}
