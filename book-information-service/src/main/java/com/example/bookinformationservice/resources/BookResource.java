package com.example.bookinformationservice.resources;


import com.example.bookinformationservice.models.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookResource {

    @RequestMapping("/{bookID}")
    public Book getBookInfo(@PathVariable("bookID") int bookID){
        return new Book(bookID, "The old man and the sea");
    }

}
