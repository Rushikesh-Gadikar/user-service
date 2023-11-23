package com.project.study.userService.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiResponse {

    String responseMessage;
    HttpStatus status;
}
