package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final VersionMapper versionMapper;
    private final DatabaseInfoMapper databaseInfoMapper;

    public HomeController(VersionMapper versionMapper, DatabaseInfoMapper databaseInfoMapper) {
        this.versionMapper = versionMapper;
        this.databaseInfoMapper = databaseInfoMapper;
    }

    @GetMapping("/console")
    public String console(Model model,
                          @CookieValue(value = "dbSsl", defaultValue = "false") boolean ssl) {
        String query = "SELECT version()";
        logger.info("Query: {}", query);
        String version = versionMapper.selectVersion();
        logger.info("Result: {}", version);
        model.addAttribute("dbVersion", version);
        model.addAttribute("dbConnectionType", ssl ? "connection.ssl" : "connection.nonssl");
        model.addAttribute("executedQuery", query);
        model.addAttribute("queryResult", version);
        return "console";
    }

    @GetMapping("/databases")
    public String databases(Model model,
                            @CookieValue(value = "dbSsl", defaultValue = "false") boolean ssl) {
        String query = "SELECT datname FROM pg_database";
        logger.info("Query: {}", query);
        List<String> databases = databaseInfoMapper.selectDatabases();
        logger.info("Result: {}", databases);
        logger.info("Query: SELECT version()");
        String version = versionMapper.selectVersion();
        logger.info("Result: {}", version);
        model.addAttribute("dbVersion", version);
        model.addAttribute("databases", databases);
        model.addAttribute("dbConnectionType", ssl ? "connection.ssl" : "connection.nonssl");
        model.addAttribute("executedQuery", query);
        model.addAttribute("queryResult", String.join(", ", databases));
        return "databases";
    }

    @GetMapping("/schemas")
    public String schemas(Model model,
                          @CookieValue(value = "dbSsl", defaultValue = "false") boolean ssl) {
        String query = "SELECT schema_name FROM information_schema.schemata";
        logger.info("Query: {}", query);
        List<String> schemas = databaseInfoMapper.selectSchemas();
        logger.info("Result: {}", schemas);
        logger.info("Query: SELECT version()");
        String version = versionMapper.selectVersion();
        logger.info("Result: {}", version);
        model.addAttribute("dbVersion", version);
        model.addAttribute("schemas", schemas);
        model.addAttribute("dbConnectionType", ssl ? "connection.ssl" : "connection.nonssl");
        model.addAttribute("executedQuery", query);
        model.addAttribute("queryResult", String.join(", ", schemas));
        return "schemas";
    }

    @GetMapping("/users")
    public String users(Model model,
                        @CookieValue(value = "dbSsl", defaultValue = "false") boolean ssl) {
        String query = "SELECT usename FROM pg_user";
        logger.info("Query: {}", query);
        List<String> users = databaseInfoMapper.selectUsers();
        logger.info("Result: {}", users);
        logger.info("Query: SELECT version()");
        String version = versionMapper.selectVersion();
        logger.info("Result: {}", version);
        model.addAttribute("dbVersion", version);
        model.addAttribute("users", users);
        model.addAttribute("dbConnectionType", ssl ? "connection.ssl" : "connection.nonssl");
        model.addAttribute("executedQuery", query);
        model.addAttribute("queryResult", String.join(", ", users));
        return "users";
    }
}
