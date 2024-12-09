package com.b2bSolutions.core.HTTPCLIENTS.controller;

import com.b2bSolutions.core.HTTPCLIENTS.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private final MovieService service;

@Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/directors")
    public ResponseEntity<Map<String, List<String>>> getDirectors(@RequestParam int threshold) {
        List<String> directors = service.getDirectors(threshold);
        return ResponseEntity.ok(Map.of("directors", directors));
    }
}
