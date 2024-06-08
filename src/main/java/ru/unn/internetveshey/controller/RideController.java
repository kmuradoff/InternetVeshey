package ru.unn.internetveshey.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.unn.internetveshey.dto.RideDto;
import ru.unn.internetveshey.services.RequestRideService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ride")
@Deprecated
public class RideController {
    private final RequestRideService rideService;

    @PostMapping("/request")
    public void requestRide(@RequestBody RideDto rideDto) {
        rideService.requestRide(rideDto);
    }

    @PostMapping("/end")
    public void endRide(String login) {
        rideService.endRide(login);
    }

    @PostMapping("/current")
    public RideDto getCurrentRide(String login) {
        return rideService.getCurrentRide(login);
    }

}
