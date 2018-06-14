package com.paysafe.cinemareservationwebapi.repository.projection;

import com.paysafe.cinemareservationwebapi.repository.hall.HallEntity;
import com.paysafe.cinemareservationwebapi.repository.movie.MovieEntity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ProjectionEntity {

  @Id
  private UUID id;

  @ManyToOne
  private MovieEntity movie;

  @OneToOne
  private HallEntity hall;

  public ProjectionEntity() { }

  public MovieEntity getMovie() {
    return movie;
  }

  public void setMovie(MovieEntity movie) {
    this.movie = movie;
  }

  public HallEntity getHall() {
    return hall;
  }

  public void setHall(HallEntity hall) {
    this.hall = hall;
  }

  public UUID getId() {
    return id;
  }
}
