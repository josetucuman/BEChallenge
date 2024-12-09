package com.b2bSolutions.core.HTTPCLIENTS.repository;

import com.b2bSolutions.core.HTTPCLIENTS.dtos.MovieResponse;

public interface MovieRepository {
    MovieResponse fetchMoviesByPage(int page);
}
