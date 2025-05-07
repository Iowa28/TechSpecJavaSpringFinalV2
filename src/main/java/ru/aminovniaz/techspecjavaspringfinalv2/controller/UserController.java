package ru.aminovniaz.techspecjavaspringfinalv2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.aminovniaz.techspecjavaspringfinalv2.dto.UserDto;
import ru.aminovniaz.techspecjavaspringfinalv2.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("users")
    public void createUser(@RequestBody @Valid UserDto userDto) {
        userService.createUser(userDto);
    }

    @GetMapping("users/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("users/{id}")
    public void updateUser(@RequestBody @Valid UserDto userDto, @PathVariable Long id) {
        userService.updateUser(userDto, id);
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
