package ru.aminovniaz.techspecjavaspringfinalv2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aminovniaz.techspecjavaspringfinalv2.dto.UserDto;
import ru.aminovniaz.techspecjavaspringfinalv2.exception.NotFoundException;
import ru.aminovniaz.techspecjavaspringfinalv2.mapper.UserMapper;
import ru.aminovniaz.techspecjavaspringfinalv2.model.User;
import ru.aminovniaz.techspecjavaspringfinalv2.repository.UserRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public void createUser(UserDto userDto) {
        User user = User.builder()
                //.id(userDto.getId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .createTime(new Date())
                .build();
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDto userDto, Long userId) {
        User user = findUser(userId);
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
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
    }

    private User findUser(Long userId) {
        return userRepository.findByIdAndFinishTimeIsNull(userId)
                .orElseThrow(() -> new NotFoundException("User not found."));
    }
}
