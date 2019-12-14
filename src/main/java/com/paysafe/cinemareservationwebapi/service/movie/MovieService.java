package com.paysafe.cinemareservationwebapi.service.movie;

import com.paysafe.cinemareservationwebapi.repository.movie.MovieEntity;
import com.paysafe.cinemareservationwebapi.repository.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie get(String name) {

        if (name == null) {
            throw new RuntimeException("Movie name cannot be null!");
        }

        Optional<MovieEntity> movieEntity = this.movieRepository.findByName(name);

        if (!movieEntity.isPresent()) {
            String message = String.format("Movie with %s doesn' t exists", name);
            throw new RuntimeException(message);
        }

        return movieEntity.get().toDomainObject();
    }

    public boolean exists(UUID movieId) {
        if (movieId == null) {
            throw new RuntimeException("Movie name cannot be null!");
        }

        return this.movieRepository.exists(movieId);
    }

    public void create(Movie movie) {

        if (movie == null) {
            throw new RuntimeException("Cannot create movie with null value!");
        }

        if (this.movieRepository.exists(movie.getId())) {
            String message = String.format("Movie with name %s already exists", movie.getName());
            throw new RuntimeException(message);
        }

        MovieEntity movieEntity = MovieEntity.toEntity(movie);

        this.movieRepository.save(movieEntity);
    }
}
