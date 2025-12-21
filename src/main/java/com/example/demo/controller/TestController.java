package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Endpoint to list all tables
    @GetMapping("/show-tables")
    public List<String> showTables() {
        return jdbcTemplate.queryForList("SHOW TABLES", String.class);
    }

    // Endpoint to show data from a specific table
    @GetMapping("/show-data")
    public List<Map<String, Object>> showData() {
        // Replace 'MY_TABLE' with your actual table name
        return jdbcTemplate.queryForList("SELECT * FROM MY_TABLE");
    }
}
