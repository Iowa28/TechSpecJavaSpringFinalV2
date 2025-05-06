package ru.aminovniaz.techspecjavaspringfinalv2.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SubscriptionDto {

    private Long id;

    private String name;

    private Date createTime;

    private Date changeTime;

    private Date finishTime;
}
