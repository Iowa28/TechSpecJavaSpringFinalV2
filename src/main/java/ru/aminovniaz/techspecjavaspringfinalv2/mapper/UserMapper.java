package ru.aminovniaz.techspecjavaspringfinalv2.mapper;

import org.mapstruct.Mapper;
import ru.aminovniaz.techspecjavaspringfinalv2.dto.UserDto;
import ru.aminovniaz.techspecjavaspringfinalv2.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    List<UserDto> usersToUserDtos(List<User> users);
}
