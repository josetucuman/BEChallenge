package com.josegelimergomez.core.client;

import com.josegelimergomez.core.config.FeignConfig;
import com.josegelimergomez.core.dto.MovieResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "movieClient", url = "${url.http.request}",
        configuration = FeignConfig.class)
public interface DirectorFeignClient {

    @GetMapping(produces = "application/json")
    MovieResponse getMovies(@RequestParam("page") int page);
}
