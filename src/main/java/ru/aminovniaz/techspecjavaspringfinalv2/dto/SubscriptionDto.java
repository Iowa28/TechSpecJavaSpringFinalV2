package ru.aminovniaz.techspecjavaspringfinalv2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SubscriptionDto {

    private Long id;

    @Size(min = 5, max = 36, message = "Name must contain from 5 to 36 characters")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    private Date createTime;

    private Date changeTime;

    private Date finishTime;
}
