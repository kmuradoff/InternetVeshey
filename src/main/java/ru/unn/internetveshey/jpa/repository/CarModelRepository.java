package ru.unn.internetveshey.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.unn.internetveshey.jpa.model.CarModel;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    CarModel findFirstById(long id);
}
