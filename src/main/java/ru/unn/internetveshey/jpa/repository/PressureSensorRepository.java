package ru.unn.internetveshey.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.unn.internetveshey.jpa.model.PressureSensorModel;

import java.util.List;

@Repository
public interface PressureSensorRepository extends JpaRepository<PressureSensorModel, Long> {
    List<PressureSensorModel> findPressureSensorModelsByLastPressureGreaterThanEqual(float pressure);
}
