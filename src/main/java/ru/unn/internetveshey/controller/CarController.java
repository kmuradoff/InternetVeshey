package ru.unn.internetveshey.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.unn.internetveshey.dto.CarBrandDto;
import ru.unn.internetveshey.dto.CarDto;
import ru.unn.internetveshey.dto.CarModelDto;
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

    @PostMapping("/brand/add")
    public ResponseEntity<String> addCarBrand(@RequestBody CarBrandDto carBrandDto) {
        return ResponseEntity.ok(String.format("Car brand %s added successfully", carBrandDto.getName()));
    }

    @PostMapping("/model/add")
    public ResponseEntity<String> addCarModel(@RequestBody CarModelDto carModelDto) {
        return ResponseEntity.ok(String.format("Car model %s added successfully", carModelDto.getName()));
    }

    @GetMapping("/{brand}")
    public ResponseEntity<List<CarDto>> getAllCarBrands(@PathVariable String brand) {
        return ResponseEntity.ok(carService.getAllCarsByBrand(brand));
    }
}
