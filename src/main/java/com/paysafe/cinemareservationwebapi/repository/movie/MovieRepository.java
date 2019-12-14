package com.paysafe.cinemareservationwebapi.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {


    Optional<MovieEntity> findByName(String name);

    boolean exists(Long movieId);

//  @Query("UPDATE MovieEntity m SET m.name=?0, m.duration=?1 WHERE M.id=?2")
//  void update(String name, Integer duration, UUID id);
}
