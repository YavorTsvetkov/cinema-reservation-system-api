package com.paysafe.cinemareservationwebapi.repository.movie;

import com.paysafe.cinemareservationwebapi.service.movie.Movie;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieEntity {

  @Id
  private UUID id;
  private String name;
  private Integer duration;

  public MovieEntity() {}

  public MovieEntity(String name, Integer duration) {
    this.name = name;
    this.duration = duration;
  }

  public Movie toDomainObject() {
    return new Movie(this.name, this.duration);
  }

  public static MovieEntity toEntity(Movie movie) {
    return new MovieEntity(movie.name, movie.duration);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public UUID getId() {
    return id;
  }
}
