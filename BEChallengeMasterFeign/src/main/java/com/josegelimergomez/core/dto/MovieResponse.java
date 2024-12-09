package com.josegelimergomez.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieResponse {
    @JsonProperty("page")
    private int page;
    @JsonProperty("per_page")
    private int perPage;
    @JsonProperty("total")
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonProperty("data")
    private List<Movie> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Movie> getData() {
        return data;
    }

    public void setData(List<Movie> data) {
        this.data = data;
    }


    public static class Movie {
        @JsonProperty("Title")
        private String title;
        @JsonProperty("Year")
        private int year;
        @JsonProperty("Rated")
        private String rated;
        @JsonProperty("Released")
        private String released;
        @JsonProperty("Runtime")
        private String runtime;
        @JsonProperty("Genre")
        private String genre;
        @JsonProperty("Director")
        private String director;
        @JsonProperty("Writer")
        private String writer;
        @JsonProperty("Actors")
        private String actors;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getRated() {
            return rated;
        }

        public void setRated(String rated) {
            this.rated = rated;
        }

        public String getReleased() {
            return released;
        }

        public void setReleased(String released) {
            this.released = released;
        }

        public String getRuntime() {
            return runtime;
        }

        public void setRuntime(String runtime) {
            this.runtime = runtime;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getWriter() {
            return writer;
        }

        public void setWriter(String writer) {
            this.writer = writer;
        }

        public String getActors() {
            return actors;
        }

        public void setActors(String actors) {
            this.actors = actors;
        }
    }
}