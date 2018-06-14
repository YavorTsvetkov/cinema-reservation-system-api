package com.paysafe.cinemareservationwebapi.service;

public class Movie {

  public final String name;
  public final Integer duration;

  public Movie(String name, Integer duration) {
    this.name = name;
    this.duration = duration;
  }
}
