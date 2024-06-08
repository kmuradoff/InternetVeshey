package ru.unn.internetveshey.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.unn.internetveshey.dto.CarBrandDto;
import ru.unn.internetveshey.dto.CarDto;
import ru.unn.internetveshey.dto.CarModelDto;
import ru.unn.internetveshey.jpa.model.*;
import ru.unn.internetveshey.jpa.repository.*;
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
    private final CarModelRepository carModelRepository;
    private final CarTariffRepository carTariffRepository;
    private final LocationRepository locationRepository;

    @Transactional
    public void addCar(CarDto carDto) {
        CarModel carModel = carModelRepository.findFirstById(carDto.getCarModel().getId());
        Car car = carMapper.toCar(carDto);
        car.setCarModel(carModel);
        CarTariff carTariff = car.getCarTariff();
        carTariffRepository.save(carTariff);
        Location startLocation = car.getStartLocation();
        Location endLocation = new Location();
        endLocation.setLatitude(0.00);
        endLocation.setLongitude(0.00);
        car.setEndLocation(endLocation);
        locationRepository.save(startLocation);
        locationRepository.save(endLocation);
        carRepository.save(car);
    }

    public CarDto getCarByRegistrationNumber(String registrationNumber) {
        return carMapper.fromCar(carRepository.findFirstByRegistrationNumber(registrationNumber));
    }

    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(carMapper::fromCar)
                .toList();
    }

    public void addCarBrand(CarBrandDto carBrandDto) {
        carBrandRepository.save(carBrandMapper.toCarBrand(carBrandDto));
    }

    public void addCarModel(String brand, CarModelDto carModelDto) {
        CarBrand carBrand = carBrandRepository.findFirstByName(brand);
        CarModel carModel = carModelMapper.toCarModel(carModelDto);
        carModel.setCarBrand(carBrand);
        carModelRepository.save(carModel);
    }
}
