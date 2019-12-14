package com.paysafe.cinemareservationwebapi.repository.movie;

import com.paysafe.cinemareservationwebapi.service.movie.Movie;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieEntity {

  @Id
  private Long id;
  private String name;
  private Integer duration;

  public Movie toDomainObject() {
    return new Movie(this.id, this.name, this.duration);
  }

  public static MovieEntity toEntity(Movie domainObject) {

    MovieEntity entity = new MovieEntity();
    entity.name = domainObject.getName();
    entity.duration = domainObject.getDurationInMinutes();

    return entity;
  }
}
