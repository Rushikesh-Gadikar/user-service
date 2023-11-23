package com.project.study.userService.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@Data
public class User {

    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;

    @Column(name = "UserName",length = 30)
    private String userName;

    @Column(name = "UserEmail")
    private String userEmail;

    @Column(name = "about")
    private String about;

    @Transient
    private List<Rating> userRatings = new ArrayList<>();
}
