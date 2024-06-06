package ru.unn.internetveshey.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.unn.internetveshey.dto.CarDto;
import ru.unn.internetveshey.services.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/add")
    public ResponseEntity<String> addCar(@RequestBody CarDto carRequest) {
        return ResponseEntity.ok(String.format("Car %s added successfully", carRequest.getRegistrationNumber()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{registrationNumber}")
    public ResponseEntity<CarDto> getCarById(@PathVariable String registrationNumber) {
        return ResponseEntity.ok(carService.getCarByRegistrationNumber(registrationNumber));
    }
}
