package ru.aminovniaz.techspecjavaspringfinalv2.service;

import ru.aminovniaz.techspecjavaspringfinalv2.dto.UserDto;

public interface UserService {

    void createUser(UserDto userDto);

    void updateUser(UserDto userDto, Long userId);

    UserDto getUser(Long userId);

    void deleteUser(Long userId);
}
