package com.paysafe.cinemareservationwebapi.repository.hall;

import com.paysafe.cinemareservationwebapi.service.hall.Hall;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HallEntity {

  @Id
  UUID id;
  String name;
  Integer numberOfSeats;

  public Hall toDomainObject() {
    return new Hall(this.name, this.numberOfSeats);
  }

  public static HallEntity toEntity(Hall domainObject) {

    HallEntity entity = new HallEntity();

    entity.name = domainObject.name;
    entity.numberOfSeats = domainObject.numberOfSeats;

    return entity;
  }
}
