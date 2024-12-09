package com.josegelimergomez.core.service.impl;

import com.josegelimergomez.core.client.DirectorFeignClient;
import com.josegelimergomez.core.dto.MovieResponse;
import com.josegelimergomez.core.exception.ApiException;
import com.josegelimergomez.core.exception.ResourceNotFoundException;
import com.josegelimergomez.core.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private DirectorFeignClient feign;


    @Override
    public List<String> getDirectors(int threshold) {
          Map<String, Long> directorsCount = new HashMap<>();
          int page = 1;
          boolean hasMorePages = true;
          try{
              while (hasMorePages){
                  MovieResponse response = feign.getMovies(page);
                  if(response == null || response.getData() == null){
                      throw new ResourceNotFoundException("No data found for the given page: " + page);
                  }
                  response.getData()
                          .stream()
                          .map(MovieResponse.Movie::getDirector)
                          .forEach(dir -> directorsCount
                                  .put(dir,
                                          directorsCount.getOrDefault(dir, 0L) +1));
                  hasMorePages = page < response.getTotalPages();
                  page++;
              }
          } catch (Exception e) {
              throw new ApiException("Error fetching data from API", e);
          }

          return directorsCount.entrySet()
                  .stream()
                  .filter(entry -> entry.getValue()>threshold)
                  .map(Map.Entry::getKey)
                  .sorted()
                  .collect(Collectors.toList());
    }
}


