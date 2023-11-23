package com.project.study.userService.feign;

import com.project.study.userService.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name ="RATING-SERVICE/ratingService",path = "/ratings")
public interface FeignConnectorForRatingService {

    @RequestMapping(method = RequestMethod.GET, value = "/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsForUserId(@PathVariable String userId);

}


