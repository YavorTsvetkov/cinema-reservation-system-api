package com.paysafe.cinemareservationwebapi.web.rest;

import com.paysafe.cinemareservationwebapi.service.movie.Movie;
import com.paysafe.cinemareservationwebapi.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "cinema/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity getMovieById(@RequestParam String name) {

        if (name == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Name cannot be null");
        }

        Movie movie = movieService.get(name);
        MovieResource movieResource = new MovieResource(movie.getId(), movie.getName(), movie.getDurationInMinutes());

        return ResponseEntity.ok(movieResource);
    }

    @PostMapping
    public ResponseEntity createMovie(@RequestBody MovieResource movieResource) {

        if (movieResource == null) {
            return ResponseEntity
                    .badRequest()
                    .body("When creating movie, cannot pass null");
        }

        Movie movie = new Movie(movieResource.getId(), movieResource.getName(), movieResource.getDurationInMinutes());

        movieService.create(movie);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
