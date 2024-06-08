package ru.unn.internetveshey.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.unn.internetveshey.jpa.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findFirstByRegistrationNumber(String registrationNumber);
    List<Car> findAllByCarModel_Name(String brand);
}
