package com.example.bookcatalogservice.recources;

import com.example.bookcatalogservice.models.Book;
import com.example.bookcatalogservice.models.CatalogItem;
import com.example.bookcatalogservice.models.Rating;
import com.example.bookcatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    BookInfo bookInfo;

    @Autowired
    UserRatingInfo userRatingInfo;

    @RequestMapping("/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID){


        UserRating userRating = userRatingInfo.getUserRating(userID);;
        return userRating.getUserRating().stream().map(rating -> bookInfo.getCatalogItem(rating))
                .collect(Collectors.toList());

    }





}

//    Book book = webClientBuilder.build()
//            .get()
//            .uri("http://localhost:8082/book/" + rating.getBookID())
//            .retrieve()
//            .bodyToMono(Book.class)
//            .block();