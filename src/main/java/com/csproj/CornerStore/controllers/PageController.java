package com.csproj.CornerStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
   /* @GetMapping("/")
    public String homeRedirect() {
        // Redirect root URL to /products
        return "redirect:/products";
    }*/
       @GetMapping("/products")
    public String productsPage() {
        return "products"; // maps to products.html in /templates
    }


        


}