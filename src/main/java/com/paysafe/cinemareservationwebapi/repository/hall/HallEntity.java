package com.paysafe.cinemareservationwebapi.repository.hall;

import com.paysafe.cinemareservationwebapi.service.Hall;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HallEntity {

  @Id
  private UUID id;
  private String name;
  private Integer numberOfSeats;

  public HallEntity() {}

  public HallEntity(String name, Integer numberOfSeats) {
    this.name = name;
    this.numberOfSeats = numberOfSeats;
  }

  public String getName() {
    return name;
  }

  public Hall toDomainObject() {
    return new Hall(this.name, this.numberOfSeats);
  }

  public static HallEntity toEntity(Hall hall) {
    return new HallEntity(hall.name, hall.numberOfSeats);
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(Integer numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public UUID getId() {
    return id;
  }
}
