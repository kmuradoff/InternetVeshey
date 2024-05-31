package ru.unn.internetveshey.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.unn.internetveshey.jpa.model.TemperatureSensorModel;

import java.util.List;

@Repository
public interface TemperatureSensorRepository extends JpaRepository<TemperatureSensorModel, Long> {
    List<TemperatureSensorModel> findTemperatureSensorModelsByLastTemperatureGreaterThanEqual(float temperature);
}
