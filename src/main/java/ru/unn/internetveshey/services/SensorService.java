package ru.unn.internetveshey.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.unn.internetveshey.jpa.model.PressureSensorModel;
import ru.unn.internetveshey.jpa.model.TemperatureSensorModel;
import ru.unn.internetveshey.jpa.repository.PressureSensorRepository;
import ru.unn.internetveshey.jpa.repository.TemperatureSensorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {
    private final TemperatureSensorRepository temperatureSensorRepository;
    private final PressureSensorRepository pressureSensorRepository;

    public List<TemperatureSensorModel> getTemperatureData() {
        return temperatureSensorRepository.findAll();
    }

    public List<PressureSensorModel> getPressureData() {
        return pressureSensorRepository.findAll();
    }

    public List<TemperatureSensorModel> getTemperatureGreaterThanEqual(float temperature) {
        return temperatureSensorRepository.findTemperatureSensorModelsByLastTemperatureGreaterThanEqual(temperature);
    }

    public List<PressureSensorModel> getPressureGreaterThanEqual(float pressure) {
        return pressureSensorRepository.findPressureSensorModelsByLastPressureGreaterThanEqual(pressure);
    }

    public void saveTemperature(TemperatureSensorModel temperatureSensorModel) {
        temperatureSensorRepository.save(temperatureSensorModel);
    }

    public void savePressure(PressureSensorModel pressureSensorModel) {
        pressureSensorRepository.save(pressureSensorModel);
    }

    public void deleteTemperature(long id) {
        TemperatureSensorModel temperatureSensorModel = temperatureSensorRepository.findById(id).orElse(null);
        Assert.notNull(temperatureSensorModel, "Temperature sensor not found");
        temperatureSensorRepository.delete(temperatureSensorModel);
    }

    public void deletePressure(long id) {
        PressureSensorModel pressureSensorModel = pressureSensorRepository.findById(id).orElse(null);
        Assert.notNull(pressureSensorModel, "Pressure sensor not found");
        pressureSensorRepository.delete(pressureSensorModel);
    }

    public void updateTemperature(long id, float temperature) {
        TemperatureSensorModel temperatureSensorModel = temperatureSensorRepository.findById(id).orElse(null);
        Assert.notNull(temperatureSensorModel, "Temperature sensor not found");
        temperatureSensorModel.setLastTemperature(temperature);
        temperatureSensorRepository.save(temperatureSensorModel);
    }

    public void updatePressure(long id, float pressure) {
        PressureSensorModel pressureSensorModel = pressureSensorRepository.findById(id).orElse(null);
        Assert.notNull(pressureSensorModel, "Pressure sensor not found");
        pressureSensorModel.setLastPressure(pressure);
        pressureSensorRepository.save(pressureSensorModel);
    }
}
