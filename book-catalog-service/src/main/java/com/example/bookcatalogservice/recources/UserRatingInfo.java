package com.example.bookcatalogservice.recources;

import com.example.bookcatalogservice.models.Rating;
import com.example.bookcatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackUserRating",
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="5"),
            @HystrixProperty(name = "circuitBreaker.isolation.errorThresholdPercentage", value="50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value="5000")
    })
    public UserRating getUserRating(@PathVariable("userID") String userID) {
        return restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userID, UserRating.class);
    }

    public UserRating getFallBackUserRating (@PathVariable("userID") String UserID){
        UserRating userRating = new UserRating();
        userRating.setUserRating(Arrays.asList(
                new Rating(1, "", 1)
        ));
        return userRating;
    }
}
