package com.paysafe.cinemareservationwebapi.repository.movie;

import com.paysafe.cinemareservationwebapi.service.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface  MovieRepository extends JpaRepository<MovieEntity, UUID> {

  Movie findByName(String name);

  boolean exists(String name);

  @Query("UPDATE MovieEntity m SET m.name=?0, m.duration=?1 WHERE M.id=?2")
  void update(String name, Integer duration, UUID id);
}
