package com.project.study.userService.service;

import com.project.study.userService.entity.Hotel;
import com.project.study.userService.entity.Rating;
import com.project.study.userService.entity.User;
import com.project.study.userService.exception.ResourceNotFoundException;
import com.project.study.userService.feign.FeignConnectorForHotelService;
import com.project.study.userService.feign.FeignConnectorForRatingService;
import com.project.study.userService.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private FeignConnectorForRatingService feignConnectorForRatingService;

    @Autowired
    private FeignConnectorForHotelService feignConnectorForHotelService;

    @Override
    public User saveUserData(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserDetailsById(int id) {
        // get single user from user repo
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found with expected id " + id));

        ResponseEntity<List<Rating>> ratingResponseEntity = feignConnectorForRatingService.getAllRatingsForUserId(String.valueOf(id));

        ResponseEntity<List<Hotel>> hotelResponseEntity = feignConnectorForHotelService.getAllHotels();

        List<Rating> newRatingList = getRatings(ratingResponseEntity, hotelResponseEntity);

        user.setUserRatings(newRatingList);

        return user;
    }

    private static List<Rating> getRatings(ResponseEntity<List<Rating>> ratingResponseEntity, ResponseEntity<List<Hotel>> hotelResponseEntity) {

        List<Rating> ratingList = ratingResponseEntity.getBody();

        List<Hotel> hotelList = hotelResponseEntity.getBody();

        List<Rating> newRatingList = new ArrayList<>();

        if (null != ratingList) {
            ratingList.forEach(rating -> {
                if (Objects.nonNull(hotelList)) {
                    hotelList.forEach(hotel -> {
                        if (Objects.equals(rating.getHotelId(), hotel.getHotelID())) {
                            rating.setHotel(hotel);
                        }
                    });
                }
                newRatingList.add(rating);
            });
        }
        return newRatingList;
    }

    @Override
    public List<User> getUserDetails() {
        return userRepository.findAll();
    }
}
