package com.b2bSolutions.core.HTTPCLIENTS.repository.impl;

import com.b2bSolutions.core.HTTPCLIENTS.dtos.MovieResponse;
import com.b2bSolutions.core.HTTPCLIENTS.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Value("${url.http.request}")
    private String httpRequest;

    @Autowired
    public MovieRepositoryImpl(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public MovieResponse fetchMoviesByPage(int page) {
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(httpRequest+page))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                return objectMapper.readValue(response.body(), MovieResponse.class);
            } else {
                throw new RuntimeException("Fallo la busqueda de la pelicula. Status Code: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching movies: " + e.getMessage(), e);
        }
    }
}
