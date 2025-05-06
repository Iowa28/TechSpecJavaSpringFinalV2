package ru.aminovniaz.techspecjavaspringfinalv2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class UserDto {

    private Long id;

    @Size(min = 5, max = 36, message = "Имя пользователя должно содержать от 5 до 36 символов")
    @NotBlank(message = "Имя пользователя не может быть пустым")
    private String username;

    @Size(min = 5, max = 36, message = "Адрес электронной почты должен содержать от 5 до 36 символов")
    @NotBlank(message = "Адрес электронной почты не может быть пустым")
    @Email(message = "Адрес электронной должен быть в формате user@example.com")
    private String email;

    private List<SubscriptionDto> subscriptions;

    private Date createTime;

    private Date changeTime;

    private Date finishTime;
}
