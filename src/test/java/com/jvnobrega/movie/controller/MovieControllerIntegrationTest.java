package com.jvnobrega.movie.controller;

import com.jvnobrega.movie.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(
        controllers = MovieController.class
        // If we exclude SpringDataWebAutoConfiguration, the Pageable parameter will not be resolved.
        // If we only exclude it on the Application class itself, the test will still work!!!
        // excludeAutoConfiguration = SpringDataWebAutoConfiguration.class
)class MovieControllerIntegrationTest {

    @MockBean
    private MovieService movieService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void evaluatesPageableParameter() throws Exception {

        mockMvc.perform(get("/api/v1/movies")
                        .param("page", "5")
                        .param("size", "10")
                        .param("sort", "id,desc") // <-- no space after comma!!!
                        .param("sort", "title,asc")) // <-- no space after comma!!!
                .andExpect(status().isOk());

        ArgumentCaptor<Pageable> pageableCaptor = ArgumentCaptor.forClass(Pageable.class);
        verify(movieService).getAllMovies(pageableCaptor.capture());

    }

}
