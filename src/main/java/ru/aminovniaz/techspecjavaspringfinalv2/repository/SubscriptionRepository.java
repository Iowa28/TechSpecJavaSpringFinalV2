package ru.aminovniaz.techspecjavaspringfinalv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;
import ru.aminovniaz.techspecjavaspringfinalv2.model.Subscription;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Optional<Subscription> findByIdAndFinishTimeIsNull(Long id);

    @NativeQuery("""
            select s.* from subscriptions s
            left join users_subscriptions us on s.subscription_id = us.subscription_id
            left join (select * from users where users.finish_time is null) u on u.user_id = us.user_id
            where s.finish_time is null
            group by s.subscription_id
            order by COUNT(u.user_id) desc
            limit 3
            """)
    List<Subscription> getTopSubscriptions();
}
