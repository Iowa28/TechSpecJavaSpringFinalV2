package ru.aminovniaz.techspecjavaspringfinalv2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.aminovniaz.techspecjavaspringfinalv2.dto.UserDto;
import ru.aminovniaz.techspecjavaspringfinalv2.exception.NotFoundException;
import ru.aminovniaz.techspecjavaspringfinalv2.mapper.UserMapper;
import ru.aminovniaz.techspecjavaspringfinalv2.model.User;
import ru.aminovniaz.techspecjavaspringfinalv2.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

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

    private User findUser(Long userId) {
        return userRepository.findByIdAndFinishTimeIsNull(userId)
                .orElseThrow(() -> new NotFoundException("User not found."));
    }
}
