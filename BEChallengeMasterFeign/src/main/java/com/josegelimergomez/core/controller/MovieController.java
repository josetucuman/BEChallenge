package com.josegelimergomez.core.controller;

import com.josegelimergomez.core.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v2")
@Tag(name = "Movie API",
        description = "API for movie directors data")
public class MovieController {

    @Autowired
    private MovieService service;

    @Operation(summary = "Get Directors", description = "Fetch directors with movies count greater than the threshold.")
    @GetMapping("/directors")
    public ResponseEntity<List<String>> getDirectors(
            @RequestParam @Min(value = 0, message = "El threshold debe ser entero no negativo")
            int threshold) {
        List<String> directors = service.getDirectors(threshold);
        return ResponseEntity.ok(directors);
    }
}
