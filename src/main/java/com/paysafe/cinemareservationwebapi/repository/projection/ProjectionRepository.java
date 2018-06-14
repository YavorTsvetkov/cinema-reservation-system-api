package com.paysafe.cinemareservationwebapi.repository.projection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectionRepository extends JpaRepository<ProjectionEntity, UUID> {
}
