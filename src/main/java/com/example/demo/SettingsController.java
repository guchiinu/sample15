package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class SettingsController {
    @GetMapping("/settings")
    public String settings(Locale locale, Model model) {
        model.addAttribute("currentLocale", locale.getLanguage());
        return "settings";
    }
}
