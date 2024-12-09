package com.josegelimergomez.core.controller;

import com.josegelimergomez.core.exception.GlobalExceptionHandler;
import com.josegelimergomez.core.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MovieControllerTest {
    @Mock
    private MovieService service;
    @InjectMocks
    private MovieController controller;

    private MockMvc mockMvc;

    public MovieControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    public void testGetDirectors_ValidThreshold()
            throws Exception {
        when(service.getDirectors(4)).thenReturn(Arrays.asList("Director A", "Director B"));

        mockMvc.perform(get("/api/v2/directors")
                        .param("threshold", "4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}
