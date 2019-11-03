package com.example.bookcatalogservice.recources;

import com.example.bookcatalogservice.models.Book;
import com.example.bookcatalogservice.models.CatalogItem;
import com.example.bookcatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackCatalogItem",
    threadPoolKey = "bookInfoPool",
    threadPoolProperties = {
            @HystrixProperty(name="coreSize", value="20"),
            @HystrixProperty(name="maxQueueSize", value="10"),
    })
    public CatalogItem getCatalogItem(Rating rating){
        Book book = restTemplate.getForObject("http://book-info-service/books" + rating.getBookID(), Book.class);
        return new CatalogItem(book.getName(), "", rating.getRating());
    }

    public CatalogItem getFallBackCatalogItem (Rating rating){
        return new CatalogItem("not found", "", rating.getRating());
    }

}
