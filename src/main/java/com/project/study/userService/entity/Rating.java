package com.project.study.userService.entity;

import lombok.Data;

@Data
public class Rating {

    private int id;
    private String rating;
    private String feedback;
    private String userId;
    private String hotelId;
    private Hotel hotel;
}
