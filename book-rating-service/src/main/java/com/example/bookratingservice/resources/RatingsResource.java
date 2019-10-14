package com.example.bookratingservice.resources;


import com.example.bookratingservice.models.Rating;
import com.example.bookratingservice.models.UserRating;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @RequestMapping("/{bookID}")
    public List<Rating> getRatings(@PathVariable("bookID") String bookID){
        List<Rating> ratings = Arrays.asList(
                new Rating(1,"1984", 2,1),
                new Rating(2,"Test", 3,2),
                new Rating(3,"New Book", 3,3)
        );
        return ratings;
    }

    @RequestMapping("users/{userID}")
    public UserRating getUserRatings(@PathVariable("userID") String userID){
        List<Rating> ratings = Arrays.asList(
                new Rating(1,"1984", 2,1),
                new Rating(2,"Test", 3,2),
                new Rating(3,"New Book", 3,3)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
