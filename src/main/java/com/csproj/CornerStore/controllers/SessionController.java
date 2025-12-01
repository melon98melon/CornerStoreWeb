package com.csproj.CornerStore.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @PostMapping("/setAdminSession")
    public void setAdminSession(HttpSession session) {
        session.setAttribute("isAdmin", true);
    }

    @PostMapping("/clearAdminSession")
    public void clearAdminSession(HttpSession session) {
        session.removeAttribute("isAdmin");
    }
}
