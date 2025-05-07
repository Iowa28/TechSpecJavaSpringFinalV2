package ru.aminovniaz.techspecjavaspringfinalv2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aminovniaz.techspecjavaspringfinalv2.dto.SubscriptionDto;
import ru.aminovniaz.techspecjavaspringfinalv2.dto.UserDto;
import ru.aminovniaz.techspecjavaspringfinalv2.exception.NotFoundException;
import ru.aminovniaz.techspecjavaspringfinalv2.mapper.SubscriptionMapper;
import ru.aminovniaz.techspecjavaspringfinalv2.mapper.UserMapper;
import ru.aminovniaz.techspecjavaspringfinalv2.model.Subscription;
import ru.aminovniaz.techspecjavaspringfinalv2.model.User;
import ru.aminovniaz.techspecjavaspringfinalv2.repository.UserRepository;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final SubscriptionMapper subscriptionMapper;

    private final SubscriptionService subscriptionService;

    @Override
    public void createUser(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .createTime(new Date())
                .build();
        userRepository.save(user);
        log.info("User with id '{}' was saved.", user.getId());
    }

    @Override
    public void updateUser(UserDto userDto, Long userId) {
        User user = findUser(userId);
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
        log.info("User with id '{}' was updated.", user.getId());
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = findUser(userId);
        return userMapper.userToUserDto(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = findUser(userId);
        user.setFinishTime(new Date());
        userRepository.save(user);
        log.info("User with id '{}' was deleted.", user.getId());
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findByFinishTimeIsNull();
        return userMapper.usersToUserDtos(users);
    }

    @Override
    public void addSubscriptionToUser(Long subscriptionId, Long userId) {
        if (Objects.isNull(subscriptionId)) {
            throw new IllegalArgumentException("Subscription id cannot be null.");
        }

        User user = findUser(userId);
        Subscription subscription = subscriptionService.findSubscription(subscriptionId);
        if (user.getSubscriptions().contains(subscription)) {
            throw new NotFoundException(MessageFormat.format("User already has subscription {0}.", subscriptionId));
        }

        user.getSubscriptions().add(subscription);
        userRepository.save(user);
    }

    @Override
    public List<SubscriptionDto> getUserSubscriptions(Long userId) {
        User user = findUser(userId);
        return subscriptionMapper.subscriptionsToDtos(user.getSubscriptions());
    }

    @Override
    public void deleteSubscriptionFromUser(Long subscriptionId, Long userId) {
        User user = findUser(userId);
        Subscription subscription = subscriptionService.findSubscription(subscriptionId);
        if (!user.getSubscriptions().contains(subscription)) {
            throw new NotFoundException(MessageFormat.format("User doesn''t has subscription {0}.", subscriptionId));
        }

        user.getSubscriptions().remove(subscription);
        userRepository.save(user);
    }

    private User findUser(Long userId) {
        return userRepository.findByIdAndFinishTimeIsNull(userId)
                .orElseThrow(() -> new NotFoundException("User not found."));
    }
}
