package com.example.bookorderservice.resources;

import com.example.bookorderservice.models.Order;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderResources {
    @RequestMapping("/{orderID}")
    public Order getOrder(@PathVariable("orderID") int orderID){
        return new Order(orderID,2,3,"The fall of the house of Usher");
    }
}
