package com.paysafe.cinemareservationwebapi.service;

import com.paysafe.cinemareservationwebapi.repository.movie.MovieEntity;
import com.paysafe.cinemareservationwebapi.repository.movie.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  public final MovieRepository movieRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public Movie get(String name) {

    if (name == null) {
      throw new RuntimeException("Movie name cannot be null!");
    }

    Movie movie = this.movieRepository.findByName(name);

    if (movie == null) {
      String message = String.format("Movie with %s doesn' t exists", name);
      throw new RuntimeException(message);
    }

    return movie;
  }

  public boolean exists(String name) {
    if (name == null) {
      throw new RuntimeException("Movie name cannot be null!");
    }

    return this.movieRepository.exists(name);
  }

  public void create(Movie movie) {

    if (movie == null) {
      throw new RuntimeException("Cannot create movie with null value!");
    }

    if (this.movieRepository.exists(movie.name)) {
      String message = String.format("Movie with name %s already exists", movie.name);
      throw new RuntimeException(message);
    }

    MovieEntity movieEntity = MovieEntity.toEntity(movie);

    this.movieRepository.save(movieEntity);
  }
}
