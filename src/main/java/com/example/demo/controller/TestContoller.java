package com.example.demo.controller; // match your folder/package

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/show-tables")
    public List<String> showTables() {
        return jdbcTemplate.queryForList("SHOW TABLES", String.class);
    }
}
