package com.project.study.userService.feign;

import com.project.study.userService.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "HOTEL-SERVICE/hotelservice",path = "/hotels")
public interface FeignConnectorForHotelService {

    @RequestMapping(method = RequestMethod.GET,value = "/getAll")
    public ResponseEntity<List<Hotel>> getAllHotels();

}
