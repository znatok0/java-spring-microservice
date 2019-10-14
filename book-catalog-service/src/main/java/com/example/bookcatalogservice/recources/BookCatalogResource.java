package com.example.bookcatalogservice.recources;

import com.example.bookcatalogservice.models.Book;
import com.example.bookcatalogservice.models.CatalogItem;
import com.example.bookcatalogservice.models.Rating;
import com.example.bookcatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
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

    @RequestMapping("/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID){

//        WebClient.Builder builder = WebClient.builder();
//
//        RestTemplate restTemplate = new RestTemplate();

        UserRating ratings = restTemplate.getForObject("http://book-rating-service/ratings/users/" + userID, UserRating.class);



        return ratings.getUserRating().stream().map(rating -> {
            Book book = restTemplate.getForObject("http://book-information-service/book/" + rating.getBookID(),Book.class);
            return new CatalogItem(book.getName(), "just description", rating.getRating());
        })
                .collect(Collectors.toList());

    }
}

//    Book book = webClientBuilder.build()
//            .get()
//            .uri("http://localhost:8082/book/" + rating.getBookID())
//            .retrieve()
//            .bodyToMono(Book.class)
//            .block();