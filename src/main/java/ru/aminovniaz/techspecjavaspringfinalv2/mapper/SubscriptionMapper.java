package ru.aminovniaz.techspecjavaspringfinalv2.mapper;

import org.mapstruct.Mapper;
import ru.aminovniaz.techspecjavaspringfinalv2.dto.SubscriptionDto;
import ru.aminovniaz.techspecjavaspringfinalv2.model.Subscription;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionDto subscriptionToDto(Subscription subscription);

    List<SubscriptionDto> subscriptionsToDtos(List<Subscription> subscriptions);
}
