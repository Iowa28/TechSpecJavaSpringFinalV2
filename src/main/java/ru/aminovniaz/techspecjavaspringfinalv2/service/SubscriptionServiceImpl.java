package ru.aminovniaz.techspecjavaspringfinalv2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aminovniaz.techspecjavaspringfinalv2.dto.SubscriptionDto;
import ru.aminovniaz.techspecjavaspringfinalv2.exception.NotFoundException;
import ru.aminovniaz.techspecjavaspringfinalv2.mapper.SubscriptionMapper;
import ru.aminovniaz.techspecjavaspringfinalv2.model.Subscription;
import ru.aminovniaz.techspecjavaspringfinalv2.repository.SubscriptionRepository;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    private final SubscriptionMapper subscriptionMapper;

    @Override
    public void createSubscription(SubscriptionDto subscriptionDto) {
        Subscription subscription = Subscription.builder()
                .name(subscriptionDto.getName())
                .createTime(new Date())
                .build();
        subscriptionRepository.save(subscription);
        log.info("Subscription with id '{}' was saved.", subscription.getId());
    }

    @Override
    public void updateSubscription(SubscriptionDto subscriptionDto, Long subscriptionId) {
        Subscription subscription = findSubscription(subscriptionId);
        subscription.setName(subscriptionDto.getName());
        subscriptionRepository.save(subscription);
        log.info("Subscription with id '{}' was updated.", subscription.getId());
    }

    @Override
    public SubscriptionDto getSubscription(Long subscriptionId) {
        Subscription subscription = findSubscription(subscriptionId);
        return subscriptionMapper.subscriptionToDto(subscription);
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {
        Subscription subscription = findSubscription(subscriptionId);
        subscription.setFinishTime(new Date());
        subscriptionRepository.save(subscription);
        log.info("Subscription with id '{}' was deleted.", subscription.getId());
    }

    @Override
    public List<SubscriptionDto> getTopSubscriptions() {
        List<Subscription> subscriptions = subscriptionRepository.getTopSubscriptions();
        return subscriptionMapper.subscriptionsToDtos(subscriptions);
    }

    @Override
    public Subscription findSubscription(Long id) {
        return subscriptionRepository.findByIdAndFinishTimeIsNull(id)
                .orElseThrow(() -> new NotFoundException("Subscription not found."));
    }
}
