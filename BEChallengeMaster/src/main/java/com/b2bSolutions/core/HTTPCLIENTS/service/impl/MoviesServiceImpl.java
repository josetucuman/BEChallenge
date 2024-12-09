package com.b2bSolutions.core.HTTPCLIENTS.service.impl;

import com.b2bSolutions.core.HTTPCLIENTS.dtos.MovieResponse;
import com.b2bSolutions.core.HTTPCLIENTS.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MoviesServiceImpl implements MovieService {

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${url.http.request}")
    private String urlHttpRequest;

    @Override
    public List<String> getDirectors(int threshold) {
        Map<String, Integer> directorCountMap = new HashMap<>();
        int page = 1;
        boolean hasMorePages = true;

        while (hasMorePages) {
            String requestUrl = urlHttpRequest + "?page=" + page;
            System.out.println("Request URL: " + requestUrl);  // Verifica la URL

            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(requestUrl))
                        .GET()
                        .build();

                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Response body for page " + page + ": " + response.body());  // Verifica el cuerpo de la respuesta

                if (response.statusCode() == 200) {
                    MovieResponse movieResponse = objectMapper.readValue(response.body(), MovieResponse.class);

                    // Itera a través de la lista de películas
                    movieResponse.getData().forEach(movie -> {
                        String director = movie.getDirector();
                        if (director != null && !director.isEmpty()) {
                            directorCountMap.put(director, directorCountMap.getOrDefault(director, 0) + 1);
                        }
                    });

                    // Si la página actual es menor que el número total de páginas, se continúa con la siguiente
                    hasMorePages = page < movieResponse.getTotalPages();
                    page++;
                } else {
                    System.out.println("Error: Received non-200 HTTP status code: " + response.statusCode());
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error occurred while making the HTTP request: " + e.getMessage());
                e.printStackTrace();
                break;
            }
        }

        // Filtra los directores que tengan más de 'threshold' ocurrencias
        List<String> result = new ArrayList<>();
        directorCountMap.forEach((director, count) -> {
            if (count > threshold) {
                result.add(director);
            }
        });

        Collections.sort(result);  // Ordena los directores alfabéticamente
        return result;
    }

}
