package com.paysafe.cinemareservationwebapi.repository.hall;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HallRepository extends JpaRepository<HallEntity, UUID> {
}
