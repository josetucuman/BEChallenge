package com.josegelimergomez.core.controller;

import com.josegelimergomez.core.client.DirectorFeignClient;
import com.josegelimergomez.core.dto.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class MovieTest {
    @Autowired
    private DirectorFeignClient feign;

    @GetMapping("/test")
    public ResponseEntity<MovieResponse> testFeignClient(@RequestParam int threshold) {
        MovieResponse response = feign.getMovies(threshold);
        return ResponseEntity.ok(response);
    }
}
