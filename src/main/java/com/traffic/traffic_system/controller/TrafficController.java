package com.traffic.traffic_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.traffic.traffic_system.model.Violation;
import com.traffic.traffic_system.service.TrafficService;

import java.util.List;

@RestController
@RequestMapping("/traffic")
@CrossOrigin
public class TrafficController {

    @Autowired
    private TrafficService service;

    @PostMapping("/check")
    public String check(@RequestBody Violation v,
                        @RequestParam boolean emergency) {

        if (service.isViolation(v.getSpeed(), emergency)) {

            v.setFine(service.calculateFine(v.getSpeed()));
            v.setTimestamp(System.currentTimeMillis());

            service.save(v);

            return "Violation detected! Fine: ₹" + v.getFine();
        }

        return "No violation";
    }

    @GetMapping("/all")
    public List<Violation> getAll() {
        return service.getAll();
    }
}