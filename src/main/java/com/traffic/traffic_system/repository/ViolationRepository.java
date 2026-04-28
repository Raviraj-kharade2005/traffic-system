package com.traffic.traffic_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.traffic.traffic_system.model.Violation;

public interface ViolationRepository extends JpaRepository<Violation, Long> {
}