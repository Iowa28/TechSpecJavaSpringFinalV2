package ru.aminovniaz.techspecjavaspringfinalv2.service;

import ru.aminovniaz.techspecjavaspringfinalv2.dto.SubscriptionDto;
import ru.aminovniaz.techspecjavaspringfinalv2.model.Subscription;

import java.util.List;

public interface SubscriptionService {

    void createSubscription(SubscriptionDto subscriptionDto);

    void updateSubscription(SubscriptionDto subscriptionDto, Long subscriptionId);

    SubscriptionDto getSubscription(Long subscriptionId);

    void deleteSubscription(Long subscriptionId);

    List<SubscriptionDto> getTopSubscriptions();

    Subscription findSubscription(Long id);
}
