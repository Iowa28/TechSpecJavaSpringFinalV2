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

    @Size(min = 5, max = 36, message = "Username must contain from 5 to 36 characters")
    @NotBlank(message = "Username cannot be empty")
    private String username;

    @Size(min = 5, max = 36, message = "Email must contain from 5 to 36 characters")
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email must be in format user@example.com")
    private String email;

    private List<SubscriptionDto> subscriptions;

    private Date createTime;

    private Date changeTime;

    private Date finishTime;
}
