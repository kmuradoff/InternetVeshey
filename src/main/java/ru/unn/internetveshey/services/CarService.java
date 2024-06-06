package ru.unn.internetveshey.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.unn.internetveshey.dto.CarDto;
import ru.unn.internetveshey.jpa.repository.CarRepository;
import ru.unn.internetveshey.mapper.CarMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public void addCar(CarDto carDto) {
        carRepository.save(carMapper.toCar(carDto));
    }

    public CarDto getCarByRegistrationNumber(String registrationNumber) {
        return carMapper.fromCar(carRepository.findFirstByRegistrationNumber(registrationNumber));
    }

    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(carMapper::fromCar)
                .toList();
    }



}
