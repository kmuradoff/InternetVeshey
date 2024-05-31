package ru.unn.internetveshey.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.unn.internetveshey.jpa.model.TemperatureSensorModel;
import ru.unn.internetveshey.services.SensorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TemperatureController {
    private final SensorService sensorService;

    @GetMapping("/temperature")
    public List<TemperatureSensorModel> getTemperatureData() {
        return sensorService.getTemperatureData();
    }

    @PostMapping("/temperature")
    public void saveTemperature(@RequestBody TemperatureSensorModel temperatureSensorModel) {
        sensorService.saveTemperature(temperatureSensorModel);
    }

    @DeleteMapping("/temperature/delete")
    public void deleteTemperature(@RequestParam long id) {
        sensorService.deleteTemperature(id);
    }

    @GetMapping("/temperature/greater")
    public List<TemperatureSensorModel> getTemperatureGreaterThanEqual(@RequestParam float temperature) {
        return sensorService.getTemperatureGreaterThanEqual(temperature);
    }

    @PostMapping("/temperature/update")
    public void updateTemperature(@RequestParam long id, @RequestParam float lastTemperature) {
        sensorService.updateTemperature(id, lastTemperature);
    }
}
