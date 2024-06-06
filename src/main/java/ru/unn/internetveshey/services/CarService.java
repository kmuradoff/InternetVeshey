package ru.unn.internetveshey.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.unn.internetveshey.dto.CarBrandDto;
import ru.unn.internetveshey.dto.CarDto;
import ru.unn.internetveshey.dto.CarModelDto;
import ru.unn.internetveshey.jpa.model.CarBrand;
import ru.unn.internetveshey.jpa.repository.CarBrandRepository;
import ru.unn.internetveshey.jpa.repository.CarRepository;
import ru.unn.internetveshey.mapper.CarBrandMapper;
import ru.unn.internetveshey.mapper.CarMapper;
import ru.unn.internetveshey.mapper.CarModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final CarBrandRepository carBrandRepository;
    private final CarBrandMapper carBrandMapper;
    private final CarModelMapper carModelMapper;

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

    public List<CarDto> getAllCarsByBrand(String brand) {
        return carRepository.findAllByCarBrand_Brand(brand).stream()
                .map(carMapper::fromCar)
                .toList();
    }

    public void addCarBrand(CarBrandDto carBrandDto) {
        carBrandRepository.save(carBrandMapper.toCarBrand(carBrandDto));
    }

    public void addCarModel(String brand, CarModelDto carModelDto) {
        CarBrand carBrand = carBrandRepository.findFirstByBrand(brand);
        carBrand.getCarModels().add(carModelMapper.toCarModel(carModelDto));
        carBrandRepository.save(carBrand);
    }
}
