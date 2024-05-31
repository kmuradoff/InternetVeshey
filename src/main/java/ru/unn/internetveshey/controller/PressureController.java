package ru.unn.internetveshey.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.unn.internetveshey.jpa.model.PressureSensorModel;
import ru.unn.internetveshey.services.SensorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PressureController {
    private final SensorService sensorService;

    @GetMapping("/pressure")
    public List<PressureSensorModel> getPressureData() {
        return sensorService.getPressureData();
    }

    @GetMapping("/pressure/greater")
    public List<PressureSensorModel> getPressureGreaterThanEqual(@RequestParam float pressure) {
        return sensorService.getPressureGreaterThanEqual(pressure);
    }

    @PostMapping("/pressure")
    public void savePressure(@RequestBody PressureSensorModel pressureSensorModel) {
        sensorService.savePressure(pressureSensorModel);
    }

    @DeleteMapping("/pressure/delete")
    public void deletePressure(@RequestParam long id) {
        sensorService.deletePressure(id);
    }

    @PostMapping("/pressure/update")
    public void updatePressure(@RequestParam long id, @RequestParam float lastPressure) {
        sensorService.updatePressure(id, lastPressure);
    }
}
