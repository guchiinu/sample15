package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final VersionMapper versionMapper;
    private final DatabaseInfoMapper databaseInfoMapper;

    public HomeController(VersionMapper versionMapper, DatabaseInfoMapper databaseInfoMapper) {
        this.versionMapper = versionMapper;
        this.databaseInfoMapper = databaseInfoMapper;
    }

    @GetMapping("/console")
    public String console(Model model) {
        model.addAttribute("dbVersion", versionMapper.selectVersion());
        return "console";
    }

    @GetMapping("/databases")
    public String databases(Model model) {
        List<String> databases = databaseInfoMapper.selectDatabases();
        model.addAttribute("dbVersion", versionMapper.selectVersion());
        model.addAttribute("databases", databases);
        return "databases";
    }

    @GetMapping("/schemas")
    public String schemas(Model model) {
        List<String> schemas = databaseInfoMapper.selectSchemas();
        model.addAttribute("dbVersion", versionMapper.selectVersion());
        model.addAttribute("schemas", schemas);
        return "schemas";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<String> users = databaseInfoMapper.selectUsers();
        model.addAttribute("dbVersion", versionMapper.selectVersion());
        model.addAttribute("users", users);
        return "users";
    }
}
