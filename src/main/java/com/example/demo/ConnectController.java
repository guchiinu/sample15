package com.example.demo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConnectController {

    @GetMapping("/")
    public String form() {
        return "connect";
    }

    @PostMapping("/connect")
    public String connect(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String database,
                          HttpServletResponse response) {
        int maxAge = 7 * 24 * 60 * 60; // 1 week

        Cookie userCookie = new Cookie("dbUser", username);
        userCookie.setPath("/");
        userCookie.setMaxAge(maxAge);

        Cookie passwordCookie = new Cookie("dbPassword", password);
        passwordCookie.setPath("/");
        passwordCookie.setMaxAge(maxAge);

        Cookie dbCookie = new Cookie("dbName", database);
        dbCookie.setPath("/");
        dbCookie.setMaxAge(maxAge);

        response.addCookie(userCookie);
        response.addCookie(passwordCookie);
        response.addCookie(dbCookie);

        return "redirect:/console";
    }
}
