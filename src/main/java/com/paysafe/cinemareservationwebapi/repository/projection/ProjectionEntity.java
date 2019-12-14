package com.paysafe.cinemareservationwebapi.repository.projection;

import com.paysafe.cinemareservationwebapi.repository.hall.HallEntity;
import com.paysafe.cinemareservationwebapi.repository.movie.MovieEntity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
class ProjectionEntity {

  @Id
  UUID id;

  @ManyToOne
  MovieEntity movie;

  @OneToOne
  HallEntity hall;
}
