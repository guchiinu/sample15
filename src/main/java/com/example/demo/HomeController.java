package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final VersionMapper versionMapper;

    public HomeController(VersionMapper versionMapper) {
        this.versionMapper = versionMapper;
    }

    @GetMapping("/")
    public String index(Model model) {
        String dbVersion = versionMapper.selectVersion();
        model.addAttribute("dbVersion", dbVersion);
        return "index";
    }
}
