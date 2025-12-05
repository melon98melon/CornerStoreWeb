package com.csproj.CornerStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {
    @GetMapping("/")
    public String homePage() {
        // Redirect root URL to /products
        return "index";
    }
    @GetMapping("/products")
    public String productsPage() {
        return "products"; // maps to products.html in /templates
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // maps to login.html in /templates
    }
    @GetMapping("/products/{id}")
    public String productDetailsPage(@PathVariable long id, Model model) {
        model.addAttribute("productId", id);
        return "product-details"; // product-details.html
    }

    @GetMapping("/admin")
    public String adminPage(HttpSession session) {
    if (session.getAttribute("isAdmin") != null) {
        return "admin"; // admin.html
    }
    return "redirect:/"; // back to index if not admin
    }
    @GetMapping("/cart")
    public String cartPage() {
        return "cart"; // maps to admin.html in /templates
    }
     @GetMapping("/wishlist")
    public String wishlistPage() {
        return "wishlist"; // maps to admin.html in /templates
    }
    @GetMapping("/logout")
    public String logoutPage() {
        return "index"; // maps to admin.html in /templates
    }

    
}