package com.example.bookinformationservice.resources;


import com.example.bookinformationservice.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/book")
public class BookResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{bookID}")
    public Book getBookInfo(@PathVariable("bookID") int bookID){
        return new Book(bookID, "The old man and the sea");
    }

}
