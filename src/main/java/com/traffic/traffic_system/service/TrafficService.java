package com.traffic.traffic_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.traffic.traffic_system.model.Violation;
import com.traffic.traffic_system.repository.ViolationRepository;

import java.util.List;

@Service
public class TrafficService {

    @Autowired
    private ViolationRepository repo;

    public boolean isViolation(double speed, boolean emergency) {
        return speed > 80 && !emergency;
    }

    public int calculateFine(double speed) {
        if (speed > 120) return 5000;
        else if (speed > 100) return 2000;
        else return 1000;
    }

    public Violation save(Violation v) {
        return repo.save(v);
    }

    public List<Violation> getAll() {
        return repo.findAll();
    }
}