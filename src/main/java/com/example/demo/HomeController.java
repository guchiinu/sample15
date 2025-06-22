package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import com.example.demo.DatabaseInfoMapper;

/**
 * Provides the home page for the simple management console.
 */

@Controller
public class HomeController {
    private final VersionMapper versionMapper;
    private final DatabaseInfoMapper databaseInfoMapper;

    public HomeController(VersionMapper versionMapper, DatabaseInfoMapper databaseInfoMapper) {
        this.versionMapper = versionMapper;
        this.databaseInfoMapper = databaseInfoMapper;
    }

    @GetMapping("/")
    public String index(Model model) {
        String dbVersion = versionMapper.selectVersion();
        model.addAttribute("dbVersion", dbVersion);

        List<String> databases = databaseInfoMapper.selectDatabases();
        List<String> schemas = databaseInfoMapper.selectSchemas();
        List<String> users = databaseInfoMapper.selectUsers();

        model.addAttribute("databases", databases);
        model.addAttribute("schemas", schemas);
        model.addAttribute("users", users);

        return "index";
    }
}
