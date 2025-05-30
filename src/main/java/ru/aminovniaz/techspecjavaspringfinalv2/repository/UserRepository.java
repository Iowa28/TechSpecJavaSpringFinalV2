package ru.aminovniaz.techspecjavaspringfinalv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aminovniaz.techspecjavaspringfinalv2.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdAndFinishTimeIsNull(Long id);

    List<User> findByFinishTimeIsNull();
}
