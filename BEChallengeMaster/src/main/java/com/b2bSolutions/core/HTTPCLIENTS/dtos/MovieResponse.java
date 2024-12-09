package com.b2bSolutions.core.HTTPCLIENTS.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;



public class MovieResponse {
    private int page;
    private int perPage;
    private int total;
    private int totalPages;

    @JsonProperty("data")
    private List<Movie> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }



    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }



    public List<Movie> getData() {
        return data;
    }

    public void setData(List<Movie> data) {
        this.data = data;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
