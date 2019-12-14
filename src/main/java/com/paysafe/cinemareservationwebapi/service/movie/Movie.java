package com.paysafe.cinemareservationwebapi.service.movie;

import java.util.UUID;

public class Movie {

  private final Long id;
  private final String name;
  private final int durationInMinutes;

  public Movie(Long id, String name, int durationInMinutes) {
    this.id = id;
    this.name = name;
    this.durationInMinutes = durationInMinutes;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getDurationInMinutes() {
    return durationInMinutes;
  }
}
