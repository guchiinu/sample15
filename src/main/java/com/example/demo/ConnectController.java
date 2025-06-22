package com.example.demo;

import jakarta.servlet.http.HttpSession;
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
                          HttpSession session) {
        session.setAttribute("dbUser", username);
        session.setAttribute("dbPassword", password);
        session.setAttribute("dbName", database);
        return "redirect:/console";
    }
}
