package ru.unn.internetveshey.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.unn.internetveshey.jpa.model.CarTariff;

@Repository
public interface CarTariffRepository extends JpaRepository<CarTariff, Long> {
}
